// https://www.youtube.com/watch?v=_uVYiM7LmSk

class Solution {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int N = vals.length;
        int ans = N;
        UnionFind uf = new UnionFind(N);
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, List<Integer>> nodeListSortedByValue = new TreeMap<>();

        for (int[] e : edges) {
            adjList.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            adjList.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        for (int i = 0; i < N; i++) {
            nodeListSortedByValue.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        for (var key : nodeListSortedByValue.keySet()) {
            var list = nodeListSortedByValue.get(key);

            for (var node : list) {
                var nbrs = adjList.get(node);

                if (nbrs == null) {
                    continue;
                }

                for (int nbr : nbrs) {
                    if (vals[node] >= vals[nbr]) {
                        uf.union(node, nbr);
                    }
                }
            }

            if (list.size() > 1) {
                for (int node : list) {
                    var parent = uf.find(node);
                    freq.put(parent, freq.getOrDefault(parent, 0) + 1);
                }

                for (var fKey : freq.keySet()) {
                    int nodeFreq = freq.get(fKey) - 1;
                    ans += (nodeFreq * (nodeFreq + 1)) / 2;
                }
            }

            freq.clear();
        }

        return ans;
    }

    static class UnionFind {
        int[] parents;
        int[] rank;

        public UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];

            while (n-- > 0) {
                parents[n] = n;
                rank[n] = 1;
            }
        }

        public int find(int x) {
            if (parents[x] == x)
                return x;
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int xx = find(x),
                    yy = find(y);

            if (xx == yy)
                return;

            if (rank[yy] < rank[xx]) {
                parents[yy] = xx;
            } else {
                parents[xx] = yy;
                if (rank[xx] == rank[yy])
                    ++rank[xx];
            }
        }
    }
}