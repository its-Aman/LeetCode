class Solution {
    public int maximumDetonation(int[][] bombs) {
        int N = bombs.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j) {
                long x = bombs[i][0]-bombs[j][0],
                    y = bombs[i][1]-bombs[j][1],
                    r = bombs[i][2];
                    
                    if(r*r >= x*x+y*y)
                        g.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                }
            }
        }
        
        int ans = 1;
        
        for(int i : g.keySet())
            ans = Math.max(ans, dfs(i, g, new boolean[N]));
        
        return ans;
    }
    
    private int dfs(int curr, Map<Integer, List<Integer>> g, boolean[] seen) {
        if(seen[curr]) return 0;
        
        
        int cnt = 1;
        seen[curr] = true;

        if(!g.containsKey(curr)) return cnt;

        for(var next: g.get(curr))
            cnt += dfs(next, g, seen);

        return cnt;
    }
}