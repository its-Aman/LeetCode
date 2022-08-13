class Solution {
    public String longestPalindrome(String S) {
        return this.longestPalindrome_DP(S);
    }

    private String longestPalindrome_DP(String S) {
        int N = S.length();
        String ans = "";
        boolean[][] dp = new boolean[N][N];
        
        for(int g = 0; g < N; g++) {
            
            for(int i = 0, j = g; j < N; i++, j++) {
                if(g == 0)
                    dp[i][j] = true;
                else if(g == 1)
                    dp[i][j] = S.charAt(i) == S.charAt(j);
                else
                    dp[i][j] = S.charAt(i) == S.charAt(j) && dp[i + 1][j - 1];

                if(dp[i][j] && j - i + 1 > ans.length())
                    ans = S.substring(i, j + 1);
            }
        }
            
        return ans;
    }
    
    private String longestPalindrome_linear(String S) {
		String max = "";

		for (int i = 0; i < S.length(); i++) {
			String even = this.helper(i, i, S);
			String odd = this.helper(i, i + 1, S);

			if (even.length() > max.length())
				max = even;

			if (odd.length() > max.length())
				max = odd;
		}

		return max;
	}

	private String helper(int left, int right, String S) {
		String currMax = "";

		while (left >= 0 && right < S.length() && S.charAt(left) == S.charAt(right)) {

			if (right - left + 1 > currMax.length())
				currMax = S.substring(left, right + 1);
			left -= 1;
			right += 1;
		}

		return currMax;
	}


    
}