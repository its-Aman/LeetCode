class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int stone: stones) {
            pq.offer(-stone);
        }
        
        while(pq.size() != 1) {
            int x = -pq.poll();
            int y = -pq.poll();
            
            if(x!=y) {
               pq.offer(y-x); 
            } else {
                pq.offer(0);
            }
        }
        
        return -pq.poll();
    }
}