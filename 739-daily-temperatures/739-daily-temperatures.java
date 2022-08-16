class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];

        for(int i = N - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            
            if(!stack.isEmpty())
                ans[i] = stack.peek() - i;
            else 
                ans[i] = 0;
            
            stack.push(i);
        }
        
        return ans;
    }
}