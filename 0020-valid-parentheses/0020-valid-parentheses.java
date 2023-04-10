class Solution {
    public boolean isValid(String s) {
        int N = s.length();
        Stack<Character> stack = new Stack();
        
        for(int i = 0; i < N; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if(stack.isEmpty()) {
                return false;
            } else {
                char c = stack.pop();
                
                if(c == '(' && s.charAt(i) == ')') {
                    continue;
                } else if(c == '[' && s.charAt(i) == ']') {
                    continue;
                } else if(c == '{' && s.charAt(i) == '}') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}