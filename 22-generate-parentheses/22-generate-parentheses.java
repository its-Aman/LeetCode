class Solution {
    private List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int N) {
        this.backtrack("", 0, 0, N);
        
        return this.ans;
    }
    
    private void backtrack(String curr, int open, int close, int N) {
        if(curr.length() == 2 * N) {
            this.ans.add(curr);
            return;
        }
    
        if(open < N)
            this.backtrack(curr.concat("("), open + 1, close, N);
        
        if(close < open)
            this.backtrack(curr.concat(")"), open, close + 1, N);
    }
}