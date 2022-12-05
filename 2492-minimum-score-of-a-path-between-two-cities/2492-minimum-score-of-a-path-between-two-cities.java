class Solution {    
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> g = new HashMap<>();

        for (var road : roads) {
            g.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            g.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        q.offer(new int[]{1, ans});

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                var curr = q.poll();
                visited.add(curr[0]);

                for (var nbrs : g.getOrDefault(curr[0], new ArrayList<>())) {
                    if (visited.contains(nbrs[0]))
                        continue;

                    q.offer(nbrs);
                    ans = Math.min(ans, nbrs[1]);
                }
            }
        }

        return ans;
    }
}