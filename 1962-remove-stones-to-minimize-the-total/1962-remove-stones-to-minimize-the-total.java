class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double ans = 0;

        for(int pile: piles) {
            ans += pile;
            pq.offer((double)pile);
        }
        
        while(k-- > 0 && !pq.isEmpty()) {
            double item = pq.poll();
            ans -= Math.floor(item / 2);
            pq.offer(Math.ceil(item / 2));
        }
        
        return (int)ans;
    }
}