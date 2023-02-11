class Solution {
    public int[] shortestAlternatingPaths(int N, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] adj = new List[N + 1];

        for (var re : redEdges) {
            if (adj[re[0]] == null) {
                adj[re[0]] = new ArrayList<>();
            }
            adj[re[0]].add(new int[]{re[1], 1});
        }

        for (var be : blueEdges) {
            if (adj[be[0]] == null) {
                adj[be[0]] = new ArrayList<>();
            }
            adj[be[0]].add(new int[]{be[1], 0});
        }

        Queue<int[]> q = new LinkedList<>();
        int[] ans = new int[N];
        boolean[][] vis = new boolean[N][2];

        q.offer(new int[]{0, 0, -1});
        Arrays.fill(ans, -1);
        vis[0][0] = vis[0][1] = true;
        ans[0] = 0;

        while (!q.isEmpty()) {
            int[] elem = q.poll();
            int curr = elem[0], depth = elem[1], prevColor = elem[2];

            if (adj[curr] == null) {
                continue;
            }

            for (int[] nextElem : adj[curr]) {
                int next = nextElem[0], color = nextElem[1];

                if (!vis[next][color] && color != prevColor) {
                    if (ans[next] == -1) {
                        ans[next] = 1 + depth;
                    }

                    vis[next][color] = true;

                    q.offer(new int[]{next, 1 + depth, color});
                }
            }
        }

        return ans;
    }
}