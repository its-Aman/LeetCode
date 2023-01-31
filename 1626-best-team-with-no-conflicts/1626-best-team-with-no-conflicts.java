class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = scores.length;
        int[] dp = new int[N];
        int[][] zip = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            zip[i] = new int[]{ages[i], scores[i]};
        }
        
        Arrays.sort(zip, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int ans = 0;

        for(int i = 0; i < N; i++) {
            dp[i] = zip[i][1];

            for(int j = i - 1; j >= 0; j--) {
            
                if(zip[i][1] >= zip[j][1]) {
                    dp[i] = Math.max(dp[i], zip[i][1] + dp[j]);
                }
                
            }

            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}