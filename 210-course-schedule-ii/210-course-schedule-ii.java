class Solution {
    private boolean[] visited;
    private List<Integer> ans;
    private Map<Integer, List<Integer>> graph;
    private int[] inDegree;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.visited = new boolean[numCourses];
        this.ans = new ArrayList<>();
        this.inDegree = new int[numCourses];
        this.buildGraph(numCourses, prerequisites);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++)
            for(int deps: this.graph.get(i))
                this.inDegree[deps] += 1;
            
        for(int i = 0; i < numCourses; i++)
            if(this.inDegree[i] == 0)
                q.offer(i);
        
        while(!q.isEmpty()) {
            int at = q.poll();
            this.ans.add(at);
            
            for(int deps: this.graph.get(at)) {
                this.inDegree[deps] -= 1;
                
                if(this.inDegree[deps] == 0)
                    q.offer(deps);
            }
        }
        
        if(this.ans.size() != numCourses)
            return new int[]{};
        
        int[] res = new int[this.ans.size()];
        
        for(int i = this.ans.size() - 1; i >= 0; i--)
            res[i] = this.ans.get(this.ans.size() - 1 - i);
        
        return res;
    }
    
    private void buildGraph(int N, int[][] prerequisites) {
        this.graph = new HashMap<>();
        
        while(N-- > 0)
            this.graph.put(N, new ArrayList<>());
        
        for(int[] conn: prerequisites)
            this.graph.get(conn[0]).add(conn[1]);
    }
}