class Solution {

    public long[] distance(int[] nums) {
        int N = nums.length;
        long[] ans = new long[N];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        for(var e: map.entrySet()) {
            long num = e.getKey();
            List<Integer> indexes = e.getValue();
            long K = indexes.size();
            long totalSum = 0, preSum = 0;

            for (long index: indexes) {
                totalSum += index;
            }
            
            for (int i = 0; i < K; i++) {
                int index = indexes.get(i);
                long postSum = totalSum - preSum - index;
                
                ans[index] += ((long)index * (long)i);
                ans[index] -= preSum;
                ans[index] -= ((long)index * (K - 1 - (long)i));
                ans[index] += postSum;
                
                preSum += index;
            }
        }


        return ans;
    }

}