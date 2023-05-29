class Solution {
    public long minimumCost(String s) {
        long ans = 0;
        int n = s.length();
        
        for(int i=1; i<n; i++) {
            ans += s.charAt(i) != s.charAt(i-1) ? Math.min(i, n-i) : 0;
        }
        
        return ans;
    }
}