class Solution {
    public int[] sortArray(int[] nums) {
        int N = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue(N);
        int[] ans = new int[N];
        
        for(int num: nums) {
            pq.offer(num);
        }
        
        while(!pq.isEmpty()) {
            ans[N - pq.size()] = pq.poll();
        }
        
        return ans;
    }
}