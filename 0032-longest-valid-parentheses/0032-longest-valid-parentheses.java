class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0, N = s.length();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(-1);
        
        for(int i = 0; i < N; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);    
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    ans = Math.max(ans, i - stack.peek());
                } else {
                    stack.push(i);    
                }
            }
        }
        
        return ans;
    }
}