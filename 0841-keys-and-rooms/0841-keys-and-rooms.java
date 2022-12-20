class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] vis = new boolean[N];
        vis[0] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                var curr = q.poll();                
                vis[curr] = true;
                
                for(var next: rooms.get(curr))
                    if(!vis[next])
                        q.add(next);
            }
        }
        
        // System.out.println(Arrays.toString(vis));
        
        for(var isUnlocked: vis)
            if(!isUnlocked)
                return false;
        
        return true;
    }
}