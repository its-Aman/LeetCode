class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] ans, count;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        count = new int[N];
    
        for(var e: edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        
        postOrderDFS(0, -1);
        preOrderDFS(0, -1);
        
        return ans;
    }
    
    private void postOrderDFS(int root, int parent) {
        if(!g.containsKey(root)) return;
        
        for(int next: g.get(root)) {
            if(next == parent) continue;
            
            postOrderDFS(next, root);
            count[root] += count[next];
            ans[root] += ans[next] + count[next];
        }
        
        count[root]++;
    }
    
    private void preOrderDFS(int root, int parent) {
        if(!g.containsKey(root)) return;
        
        for(int next: g.get(root)) {
            if(next == parent) continue;

            ans[next] = ans[root] - count[next] + count.length - count[next];
            preOrderDFS(next, root);
        }        
    }
}