class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int idxOfLastMaxHeight = stack.pop();
                
                if(stack.isEmpty())
                    break;
                
                int distance = (i - 1) - stack.peek();
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[idxOfLastMaxHeight];
                ans += distance * boundedHeight;
            }
            
            stack.push(i);           
        }
        
        return ans;
    }
}