class Solution {
    int[] par, size, weight;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        init(n);
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        for (var edge : edgeList) {
            union(edge[0], edge[1], edge[2]);
        }

        for (int i = 0; i < queries.length; i++) {
            ans[i] = find(queries[i][0], queries[i][2]) == find(queries[i][1], queries[i][2]);
        }

        return ans;
    }

    private void init(int N) {
        par = new int[N];
        size = new int[N];
        weight = new int[N];

        while (N-- > 0) {
            par[N] = N;
        }

    }

    public int find(int x, int limit) {
        while (x != par[x]) {
            if (weight[x] >= limit) {
                break;
            }
            x = par[x];
        }

        return x;
    }

    public void union(int x, int y, int limit) {
        int xx = find(x, Integer.MAX_VALUE), yy = find(y, Integer.MAX_VALUE);

        if (xx == yy) {
            return;
        }

        if (size[xx] > size[yy]) {
            par[yy] = xx;
            weight[yy] = limit;
        } else {
            par[xx] = yy;
            weight[xx] = limit;

            if (size[xx] == size[yy]) {
                size[yy]++;
            }
        }
    }
}