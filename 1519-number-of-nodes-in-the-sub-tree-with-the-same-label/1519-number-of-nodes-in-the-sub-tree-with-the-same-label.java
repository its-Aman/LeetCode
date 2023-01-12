class Solution {
    int[] ans;
    char[] label;
    Map<Integer, List<Integer>> g = new HashMap<>();
    
    public int[] countSubTrees(int N, int[][] edges, String labels) {
        ans = new int[N];
        label = labels.toCharArray();
        
        for(int[] edge: edges) {
            g.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            g.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        
        dfs(0, -1);

        return ans;
    }
    
    private int[] dfs(int node, int parent) {
        int[] nodeCnt = new int[26];
        nodeCnt[label[node] - 'a'] = 1;
        
        if(!g.containsKey(node)) {
            return nodeCnt;
        }
        
        for(int next: g.get(node)) {
            if(next == parent) {
                continue;
            }
            
            int[] childCnt = dfs(next, node);
            
            for(int i = 0; i < 26; i++) {
                nodeCnt[i] += childCnt[i];
            }
        }
        
        ans[node] = nodeCnt[label[node] - 'a'];
        return nodeCnt;
    }
}