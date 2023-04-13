class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int N = pushed.length;
        
        for(int i = 0, j = 0; i < N; i++) {
            stack.push(pushed[i]);

            while(!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } 
        }
        
        return stack.isEmpty();
    }
}