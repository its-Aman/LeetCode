class Solution {
    
    public int numDecodings(String s) {
        if (s.length() == 1)
            return s.equals("0") ? 0 : 1;

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return findWays(dp, s, 0);
    }

    private int findWays(int[] dp, String s, int idx) {
        if (s == null || s.length() == 0 || idx >= s.length())
            return 1;

        if (dp[idx] != -1)
            return dp[idx];

        int currentTotal = 0;

        if (idx + 2 <= s.length()) {
            String secondStr = s.substring(idx, idx + 2);
            if (!secondStr.startsWith("0")) {
                int second = Integer.parseInt(secondStr);
                if (second >= 1 && second <= 26) {
                    currentTotal += findWays(dp, s, idx + 2);
                }
            }
        }

        if (idx + 1 <= s.length()) {
            String firstStr = s.substring(idx, idx + 1);
            if (!firstStr.startsWith("0")) {
                int first = Integer.parseInt(firstStr);
                if (first >= 1 && first <= 26) {
                    currentTotal += findWays(dp, s, idx + 1);
                }
            }
        }

        dp[idx] = currentTotal;
        return currentTotal;
    }
}