class Solution {
    private long getCost(int[] nums, int[] cost, int base) {
        long result = 0l;
        
        for(int i=0; i<nums.length; i++) {
            result += 1l*Math.abs(nums[i]-base)*cost[i];
        }
        
        return result;
    }
    
    public long minCost(int[] nums, int[] cost) {
        int low=1000001, hi=0;
        
        for(int num: nums) {
            low=Math.min(num, low);
            hi=Math.max(num, hi);    
        }
        
        long ans=getCost(nums, cost, nums[0]);
        
        while(low<hi) {
            int mid=(low+hi)/2;
            long cost1=getCost(nums, cost, mid);
            long cost2=getCost(nums, cost, mid+1);
            ans=Math.min(cost1, cost2);
            
            if(cost1>cost2) low = mid+1;
            else hi=mid;
        }
        
        return ans;
    }
    
    public long minCost2(int[] nums, int[] cost) {
        int N = nums.length;
        int[][] numsAndCost = new int[N][2];
        
        for(int i=0; i<N; i++) numsAndCost[i] = new int[]{nums[i], cost[i]};
        
        Arrays.sort(numsAndCost, Comparator.comparingInt(a -> a[0]));
        
        long[] prefixCost = new long[N];
        prefixCost[0] = numsAndCost[0][1];
        
        for(int i=1; i<N; i++) prefixCost[i] = numsAndCost[i][1] + prefixCost[i-1];
        
        long totalCost = 0l;
        
        for(int i=1; i<N; i++) totalCost += 1l*numsAndCost[i][1]*(numsAndCost[i][0]-numsAndCost[0][0]);

        long ans = totalCost;
        
        for(int i=1; i<N; i++) {
            int free = numsAndCost[i][0]-numsAndCost[i-1][0];
            totalCost += 1l*prefixCost[i-1]*free;
            totalCost -= 1l*(prefixCost[N-1]-prefixCost[i-1])*free;
            ans = Math.min(ans, totalCost);
        }

        return ans;
    }
}