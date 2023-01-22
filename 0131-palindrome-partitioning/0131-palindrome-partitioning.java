class Solution {
    List<List<String>> ans = new ArrayList<>();
    boolean[][] isPali;
    
    public List<List<String>> partition(String s) {
        int N = s.length();
        isPali = new boolean[N][N];
        
        go(s, 0, new ArrayList<String>());
        
        return ans;
    }
    
    private void go(String s, int idx, List<String> curr) {
        if(idx >= s.length()) {
            ans.add(new ArrayList<String>(curr));
        }
        
        for(int i = idx; i < s.length(); i++) {

            if(s.charAt(idx) == s.charAt(i) && ((i - idx <= 2) || isPali[idx + 1][i - 1])) {
                isPali[idx][i] = true;
                curr.add(s.substring(idx, i + 1));
                go(s, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
        
    }
}