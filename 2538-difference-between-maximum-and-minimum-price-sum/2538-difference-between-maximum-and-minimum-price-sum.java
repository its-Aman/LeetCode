class Solution {
    Map<Integer, Map<Integer, Long>> g = new HashMap<>();

    public long maxOutput(int N, int[][] edges, int[] price) {
        long ans = 0;

        for (int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new HashMap<>()).put(e[1], 0l);
            g.computeIfAbsent(e[1], k -> new HashMap<>()).put(e[0], 0l);
        }

        for (int key : g.keySet()) {
            if (g.get(key).size() == 1) {
                ans = Math.max(ans, dfs(key, -1, price) - price[key]);
            }
        }

        return ans;
    }

    private long dfs(int curr, int par, int[] price) {
        long maxPath = 0;

        for (var next : g.get(curr).keySet()) {
            if (next == par) {
                continue;
            }

            long currCost = g.get(curr).get(next);

            if (currCost == 0) {
                currCost = dfs(next, curr, price);
                g.get(curr).put(next, currCost);
            }
            
            maxPath = Math.max(maxPath, currCost);
        }

        return maxPath + price[curr];
    }
}