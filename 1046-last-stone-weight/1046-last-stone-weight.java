class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int stone: stones) {
            pq.offer(-stone);
        }
        
        while(!pq.isEmpty()) {
            if(pq.size() == 1) {
                return -pq.poll();
            }
            
            int x = -pq.poll();
            int y = -pq.poll();
            
            if(x!=y) {
               pq.offer(-Math.abs(x-y)); 
            }
            
            if(pq.isEmpty()) {
                return 0;
            }
        }
        
        return 0;
    }
}