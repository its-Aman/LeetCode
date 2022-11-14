class Solution {
    int[] parents, size;

    public int removeStones(int[][] stones) {
        int N = stones.length, R = 0, C = 0;

        for (var stone : stones) {
            R = Math.max(R, stone[0]);
            C = Math.max(C, stone[1]);
        }

        R++;
        C++;

        setup(R + C);

        for (var stone : stones)
            union(stone[0], stone[1] + R);

        int count = 0;
        int[] cnt = new int[R + C];

        for (var stone : stones)
            ++cnt[find(stone[0])];

        for (int c : cnt)
            if (c > 0) count++;

        return N - count;
    }

    private void union(int x, int y) {
        int xx = find(x),
                yy = find(y);

        if (xx == yy)
            return;

        if (size[xx] >= size[yy]) {
            parents[yy] = xx;
            size[xx] += size[yy];
        } else {
            parents[xx] = yy;
            size[yy] += size[xx];
        }

    }

    private int find(int x) {
        if (x == parents[x])
            return x;

        return parents[x] = find(parents[x]);
    }

    private void setup(int N) {

        parents = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }
}