class Solution {
    public int numDecodings2(String s) {
        int N = s.length();
        int[] dp = new int[N + 1];
        
        dp[N] = 1;
        
        for(int i = N - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if(i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                dp[i] += dp[i + 2];                
            }
        }
        
        return s.equals("0") ? 0 : dp[0];
    }    

    public int numDecodings(String s) {
        int N = s.length();
        int one = 1, two = 0;
        
        for(int i = N - 1; i >= 0; i--) {
            int curr = s.charAt(i) == '0' ? 0 : one;
            
            if(i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                curr += two;

            two = one;
            one = curr;
        }
        
        return s.equals("0") ? 0 : one;
    }    

}