class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        
        for(var conn: connections) {
            g.computeIfAbsent(conn[0], k -> new ArrayList<>()).add(new int[]{conn[1], 0});
            g.computeIfAbsent(conn[1], k -> new ArrayList<>()).add(new int[]{conn[0], 1});
        }
        
        q.offer(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();
                
                for(var next: g.getOrDefault(curr, new ArrayList<>())) {
                    if(vis[next[0]]) {
                        continue;
                    }
                    
                    vis[next[0]] = true;

                    n -= next[1];    
                    
                    q.offer(next[0]);
                }
            }
        }
        
        return n - 1;
    }
}