class Solution {
    public int numWays(String[] words, String target) {
        int n = target.length();
        int MOD = 1000000007;

        long[] dp = new long[n+1];
        dp[0] = 1; // dp[j] means the number of ways to form target j first characters.

        
        for(int i=0; i<words[0].length(); i++) {
            int[] cnt = new int[26];
            
            for(String word: words) {
                cnt[word.charAt(i)-'a']++;
            }
            
            for(int j=n-1; j>=0; --j) {
                dp[j+1] += (dp[j]*cnt[target.charAt(j)-'a'])%MOD;
            }
        }
        
        return (int)(dp[n]%MOD);
        
    } 
    
    public int numWays2(String[] words, String target) {
        int n = words.length;
        int m = target.length();
        int k = words[0].length();
        int MOD = 1000000007;
        
        long[][] dp = new long[m+1][k+1];
        int[][] cnt = new int[26][k+1];
        
        for(int i=0; i<k; i++) {
            for(String word: words) {
                cnt[word.charAt(i)-'a'][i]++;
            }
        }
        
        dp[0][0] = 1;
        
        for(int i=0; i<=m; i++) {
            for(int j=0; j<k; j++) {
                if(i<m) {
                    dp[i+1][j+1] += cnt[target.charAt(i)-'a'][j]*dp[i][j];
                    dp[i+1][j+1] %= MOD;
                }

                dp[i][j + 1] += dp[i][j];
                dp[i][j+1] %= MOD;
            }
        }

        return (int)dp[m][k];
    }
}