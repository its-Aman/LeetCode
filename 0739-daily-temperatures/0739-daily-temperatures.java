class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return dailyTemperatures_stack(temperatures);
    }
    
    public int[] dailyTemperatures_stack(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int N = temperatures.length;
        int[] ans = new int[N];
        
        for(int i = N - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
                stack.pop();
            
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        
        return ans;
    }
    
    
    public int[] dailyTemperatures_linear(int[] temperatures) {
        int N = temperatures.length, hottest = 0;
        int[] ans = new int[N];
        
        for(int i = N - 1; i >= 0; i--) {
            if(temperatures[i] > hottest) {
                hottest = temperatures[i];
                continue;
            }
            
            int cnt = 1;
            
            while(temperatures[i + cnt] < temperatures[i])
                cnt += ans[i + cnt];
            
            ans[i] = cnt;
        }
        
        return ans;
    }
}