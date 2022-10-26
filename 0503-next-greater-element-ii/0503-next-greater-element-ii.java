class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int N = nums.length;
        int[] ans = new int[N];
        
        int i = 2*N-1;
        
        while(i >= 0) {
            while(!stack.isEmpty() && stack.peek() <= nums[i%N])
                stack.pop();

            ans[i%N]= stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(nums[i%N]);
            i--;
        }
        
        return ans;
    }
}