class Solution {
    public boolean validPath(int N, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        
        for(var e: edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);    
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        
        q.offer(source);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();
                
                if(curr == destination)
                    return true;
                
                vis.add(curr);
                
                for(var next: g.getOrDefault(curr, new ArrayList<>()))
                    if(!vis.contains(next))
                        q.offer(next);
                
            }
        }
        
        
        return false;
    }
}