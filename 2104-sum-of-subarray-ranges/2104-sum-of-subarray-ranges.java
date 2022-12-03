class Solution {
    public long subArrayRanges(int[] nums) {
        return subArrayRanges_N(nums);
    }

    private long subArrayRanges_N(int[] nums) {
        long ans = 0;
        int N = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int right = 0; right <= N; right++) {
            while(!stack.isEmpty() && (right == N || nums[stack.peek()] >= nums[right])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ans -= (long)nums[mid] * (right - mid) * (mid - left);
            }
            
            stack.push(right);
        }
        
        stack.clear();

        for(int right = 0; right <= N; right++) {
            while(!stack.isEmpty() && (right == N || nums[stack.peek()] <= nums[right])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ans += (long)nums[mid] * (right - mid) * (mid - left);
            }
            
            stack.push(right);
        }
        
        return ans;
    }
    
    public long subArrayRanges_N2(int[] nums) {
        long ans = 0;
        int N = nums.length;
        
        for(int i = 0; i < N; i++) {
            int min = nums[i],
                max = nums[i];

            for(int j = i; j < N; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                
                ans += max - min;
            }
        }
        
        return ans;
    }
}