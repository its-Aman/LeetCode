class Solution {
    public String removeDuplicates(String s) {
        return removeDuplicates_twoPointer(s);
    }

    public String removeDuplicates_twoPointer(String s) {
        char[] ch = s.toCharArray();
        int N = ch.length;
        int i = 0;
        
        for(int j = 0; j < N; j++, i++) {
            ch[i] = ch[j];
            
            if(i > 0 && ch[i] == ch[i-1])
                i -= 2;
        }
        
        return new String(ch, 0, i);
    }
    
    public String removeDuplicates_stack(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);            
        }
        
        for(char c: stack)
            sb.append(c);
        
        return sb.toString();
    }
}