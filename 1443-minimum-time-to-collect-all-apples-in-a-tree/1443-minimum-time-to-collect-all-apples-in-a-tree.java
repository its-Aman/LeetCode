class Solution {
    
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) { 
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(parent, -1);
        parent[0] = 0;
        visited[0] = true;
        
        // Build tree like structure with each child pointing to its parent node
        // edge[0] is parent by default for edge[1]. 
        // If edge[1] is already assigned a parent, then make edge[1] a parent of edge[0]
            
        for (int[] edge : edges) {
            if (parent[edge[1]] == -1) {
                parent[edge[1]] = edge[0];
            } else {
                parent[edge[0]] = edge[1];
            }
        }
            
        // System.out.println(Arrays.toString(parent));

        int timeSpent = 0;

        for (int node = 1; node < n; ++node) {
            if (hasApple.get(node)) {
                for (int parentNode = node; !visited[parentNode]; parentNode = parent[parentNode]) {
                    // System.out.println("Visiting: " + parentNode);
                    visited[parentNode] = true;
                    timeSpent += 2;
                }
            }
        }

        return timeSpent;

    }
    
    
    
    Map<Integer, List<Integer>> g = new HashMap<>();  
    
    public int minTime2(int N, int[][] edges, List<Boolean> hasApple) {
        for(int[] e: edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        
        return dfs(0, -1, hasApple);
    }
    
    private int dfs(int node, int par, List<Boolean> hasApple) {
        int totalTime = 0, childTime = 0;
        
        if(!g.containsKey(node)) {
            return totalTime;
        }
        
        for(int next: g.get(node)) {
            if(next == par) {
                continue;
            }
            
            childTime = dfs(next, node, hasApple);

            if(childTime > 0 || hasApple.get(next)) {
                totalTime += childTime + 2;
            }
        }
        
        return totalTime;
    }
}