class Solution {
    
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32)
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        
        for(char c: stack)
            sb.append(c);
        
        return sb.toString();
    }
    
    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder();
        int N = s.length();
        boolean isGood = false;
        
        while(!isGood && N > 0) {
            boolean next = true;
            
            for(int i = 0; i < N; i++) {
                if(isBad(s, i)) {
                    next = false;
                    i++;
                } else {
                    sb.append(s.charAt(i));
                }
                // System.out.println(sb);
            }
            
            s = sb.toString();
            N = s.length();
            sb.setLength(0);
            isGood = next;
        }
        
        return s;
    }
    
    private boolean isBad(String s, int idx) {
        if(idx + 1 == s.length())
            return false;
        
        int diff = 'a' - 'A';
        return (Math.abs(s.charAt(idx) - s.charAt(idx + 1)) == diff);
    }
}