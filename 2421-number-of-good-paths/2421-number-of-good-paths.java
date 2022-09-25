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

        for (int i = 0; i < N; i++)
            nodeListSortedByValue.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);

        var keys = nodeListSortedByValue.keySet();

        for (var key : keys) {
            var list = nodeListSortedByValue.get(key);

            for (var node : list) {
                var nbrs = adjList.get(node);

                if (nbrs == null) continue;

                for (int nbr : nbrs)
                    if (vals[node] >= vals[nbr]) uf.union(node, nbr);
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

    
    
/*------------------------------------------------------------------------------------------*/    

    public int numberOfGoodPaths_(int[] vals, int[][] edges) {
        int N = vals.length;
        int ans = 0;
        Map<Integer, List<Integer>> g = new HashMap<>();
        List<int[]> okNodes = new ArrayList<>();

        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        Map<Integer, Integer> uniq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (uniq.containsKey(vals[i])) {
                okNodes.add(new int[]{uniq.get(vals[i]), i});
            } else {
                uniq.put(vals[i], i);
            }
        }

        System.out.println(uniq);

        for (int i = 0; i < okNodes.size(); i++) {
            int[] ok = okNodes.get(i);
            int start = ok[0];
            int end = ok[1];
            if (go(g, start, end, vals))
                ans++;
        }

        return ans + N;
    }

    private boolean go(Map<Integer, List<Integer>> g, int start, int end, int[] vals) {
        Set<Integer> seen = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                var curr = q.poll();
                var nbrs = g.getOrDefault(curr, new ArrayList<>());
                seen.add(curr);

                for (int i = 0; i < nbrs.size(); i++) {
                    int nbr = nbrs.get(i);
                    if (!seen.contains(nbr) && vals[start] < vals[nbr]) {
                        return false;
                    }
                    if (nbr == end)
                        return true;
                }
            }
        }
        return true;
    }
}