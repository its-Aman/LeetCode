class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    char[] ch;
    int ans = 1;
    
    public int longestPath(int[] parent, String s) {
        ch = s.toCharArray();
        
        for(int i = 1; i < parent.length; i++) {
            g.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        }
        
        dfs(0);
        
        return ans;
    }
    
    private int dfs(int node) {        
        if(!g.containsKey(node)) {
            return 1;
        }
        
        int longestChain = 0, secondLongestChain = 0;

        for(int next: g.get(node)) {
            int longestChainStartingFromChild = dfs(next);

            if(ch[node] == ch[next]) {
                continue;
            }
            
            if(longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if(longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
            
        }
        
        ans = Math.max(ans, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }
}