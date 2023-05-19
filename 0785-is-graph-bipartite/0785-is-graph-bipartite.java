class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] colors = new int[N];
        
        for(int i=0; i<N; i++) {
            if(colors[i] == 0 && !dfs(graph, colors, i, 1)) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if(colors[node] != 0) return colors[node] == color;
        
        colors[node] = color;
        
        for(int next: graph[node]) {
            if(!dfs(graph, colors, next, -color)) return false;
        }
        
        return true;
    }
}