class Solution {
    boolean[][] isPali;
    int[] dp;

    public int maxPalindromes(String s, int k) {
        int N = s.length();

        if (k == 1)
            return N;

        dp = new int[N];
        isPali = new boolean[N][N];

        for (int len = 1; len <= k + 1; len++)
            for (int i = 0, j = i + len - 1; j < N; i++, j++)
                isPali[i][j] = (len < 3 || isPali[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));

        return maxPalindromes(s, k, 0);
    }

    public int maxPalindromes(String s, int k, int idx) {
        int N = s.length();
        if (idx + k > N)
            return 0;

        if (dp[idx] == 0) {
            dp[idx] = 1 + maxPalindromes(s, k, idx + 1);
            if (isPali[idx][idx + k - 1])
                dp[idx] = Math.max(dp[idx], 2 + maxPalindromes(s, k, idx + k));
            if (idx + k < N && isPali[idx][idx + k])
                dp[idx] = Math.max(dp[idx], 2 + maxPalindromes(s, k, idx + k + 1));
        }
        
        return dp[idx] - 1;
    }
}


// https://www.youtube.com/watch?v=0VhLorHKiVM

class Solution2 {
    boolean[][] isPali, isCalc;
    int[] dp;

    public int maxPalindromes(String s, int k) {
        int N = s.length();
        dp = new int[N];
        isPali = new boolean[N][N];
        isCalc = new boolean[N][N];

        Arrays.fill(dp, -1);
        isPalindrome(s, 0, N - 1);

        return maxPalindromes(s, k, 0);
    }

    private int maxPalindromes(String s, int k, int idx) {
        int N = s.length();
        if (idx == N)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        dp[idx] = maxPalindromes(s, k, idx + 1);

        for (int i = idx + k - 1; i < N; i++)
            if (isPalindrome(s, idx, i))
                dp[idx] = Math.max(dp[idx], 1 + maxPalindromes(s, k, i + 1));

        return dp[idx];
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;

        if (isCalc[i][j])
            return isPali[i][j];

        isCalc[i][j] = true;

        if (s.charAt(i) == s.charAt(j))
            isPali[i][j] = isPalindrome(s, i + 1, j - 1);
        else
            isPali[i][j] = false;
        
        return isPali[i][j];
    }
}