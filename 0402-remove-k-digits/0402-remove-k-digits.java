class Solution {
    public String removeKdigits(String num, int K) {
        if(K >= num.length()) {
            return "0";
        }
        
        Deque<Character> d = new ArrayDeque<>();
        
        for(char c: num.toCharArray()) {
            while(K > 0 && !d.isEmpty() && d.peekLast() > c) {
                d.removeLast();
                K--;
            }
            d.addLast(c);
        }
        
        while(K > 0) {
            d.removeLast();
            K--;
        }
        
        while(!d.isEmpty() && d.peekFirst() == '0') {
            d.removeFirst();
        }
        
        if(d.isEmpty()) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!d.isEmpty()) {
            sb.append(d.removeFirst());
        }
        
        return sb.toString();
    }
}