class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0;

        for(int pile: piles) {
            ans += pile;
            pq.offer(pile);
        }
        
        while(k-- > 0 && !pq.isEmpty()) {
            int item = pq.poll();
            pq.offer(item - item / 2);
            ans -= item / 2;
        }
        
        return ans;
    }
}