class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int N = queries.length;
        boolean[] ans = new boolean[N];
        int[][] queriesI = new int[N][4];
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < N; i++) {
            queriesI[i][0] = queries[i][0];
            queriesI[i][1] = queries[i][1];
            queriesI[i][2] = queries[i][2];
            queriesI[i][3] = i;
        }

        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(queriesI, Comparator.comparingInt(a -> a[2]));

        for (int qI = 0, eI = 0; qI < N; qI++) {
            int p = queriesI[qI][0],
                    q = queriesI[qI][1],
                    dis = queriesI[qI][2],
                    i = queriesI[qI][3];

            while (eI < edgeList.length && edgeList[eI][2] < dis) {
                uf.union(edgeList[eI][0], edgeList[eI][1]);
                eI++;
            }
            ans[i] = uf.isConnected(p, q);
        }

        return ans;
    }
}

class UnionFind {
    int[] par, size;

    UnionFind(int N) {
        par = new int[N];
        size = new int[N];

        while (N-- > 0) {
            par[N] = N;
        }
    }

    public int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]);
        }

        return par[x];
    }

    public void union(int x, int y) {
        int xx = find(x), yy = find(y);

        if (xx == yy) {
            return;
        }

        if (size[xx] > size[yy]) {
            par[yy] = xx;
        } else if (size[xx] < size[yy]) {
            par[xx] = yy;
        } else {
            par[xx] = yy;
            size[yy]++;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}