class Solution {
    private List<String> ans = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    
    public List<String> generateParenthesis(int N) {
        this.backtrack(0, 0, N);
        
        return this.ans;
    }
    
    private void backtrack(int open, int close, int N) {
        if(sb.length() == 2 * N) {
            this.ans.add(sb.toString());
            return;
        }
    
        if(open < N) {
            sb.append("(");
            this.backtrack(open + 1, close, N);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(close < open) {
            sb.append(")");
            this.backtrack(open, close + 1, N);
            sb.deleteCharAt(sb.length() - 1);            
        }
    }
}