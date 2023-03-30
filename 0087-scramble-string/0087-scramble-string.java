class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int N = s1.length();
        boolean[][][] dp = new boolean[N][N][N + 1];

        for (int k = 1; k <= N; k++) {
            for (int i = 0; i + k <= N; i++) {
                for (int j = 0; j + k <= N; j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int q = 1; q < k && !dp[i][j][k]; q++) {
                            boolean left = dp[i][j][q] && dp[i + q][j + q][k - q];
                            boolean right = dp[i][j + k - q][q] && dp[i + q][j][k - q];
                            dp[i][j][k] = left || right;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][N];
    }

    public boolean isScramble2(String s1, String s2) {
        int N = s1.length();
        boolean[][][] dp = new boolean[N + 1][N][N];
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][1] = c1[i] == c2[j];
            }
        }

        for (int length = 2; length <= N; length++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean[] dp1 = dp[newLength][i];
                        boolean[] dp2 = dp[length - newLength][i + newLength];
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];
                    }
                }
            }
        }

        return dp[N][0][0];
    }
    }