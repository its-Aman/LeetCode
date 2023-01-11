class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();  
    
    public int minTime(int N, int[][] edges, List<Boolean> hasApple) {
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