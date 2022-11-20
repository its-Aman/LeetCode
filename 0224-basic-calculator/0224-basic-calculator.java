class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, sign = 1, ans = 0;
        
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if(c == '+') {
                ans += num * sign;
                sign = 1;
                num = 0;
            } else if(c == '-') {
                ans += num * sign;
                sign = -1;
                num = 0;
            } else if(c == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if(c == ')') {
                ans += sign * num;
                ans *= stack.pop();
                ans += stack.pop();
                num = 0;
            }
        }
        
        if(num != 0)
            ans += sign * num;
        
        return ans;
    }
}