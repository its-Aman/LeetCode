class Solution {
    public int maximumDetonation(int[][] bombs) {
        int N = bombs.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j && detonates(i, j, bombs))
                    g.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < N; i++)
            ans = Math.max(ans, dfs(i, g, new boolean[N]));
        
        return ans;
    }
    
    private int dfs(int curr, Map<Integer, List<Integer>> g, boolean[] seen) {
        if(seen[curr]) return 0;
        
        int cnt = 1;
        seen[curr] = true;
        
        for(var next: g.getOrDefault(curr, new ArrayList<>()))
            cnt += dfs(next, g, seen);

        return cnt;
    }
    
    private boolean detonates(int i, int j, int[][] bombs) {
        long x = bombs[i][0]-bombs[j][0],
                y = bombs[i][1]-bombs[j][1],
                r = bombs[i][2];
        
        return r*r >= x*x+y*y;
    }
}