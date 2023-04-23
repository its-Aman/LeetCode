class Solution {
    public int numberOfArrays(String s, int k) {
        int MOD = 1000000007;
        int N = s.length();
        int[] dp = new int[N+1];
        dp[0] = 1;
        
        for(int i=0; i<N; i++) {
            if(s.charAt(i) == '0') {
                continue;
            }
            
            for(int j=i; j<N; j++) {
                if(Long.parseLong(s.substring(i, j+1)) > k) {
                    break;
                }
                
                dp[j+1] = (dp[j+1] + dp[i])%MOD;
            }
        }
        
        return dp[N];
    }
}