class Solution {
    public int maxCount(int[] banned, int N, int maxSum) {
        int ans = 0;
        boolean[] ban = new boolean[N + 1];
        
        for (int b : banned) {
            if(b <= N) {
                ban[b] = true;
            }
        }

        for (int i = 1; i <= N && maxSum >= 0; i++) {
            if (ban[i]) {
                continue;
            }

            maxSum -= i;
            if(maxSum >= 0) {
                ans++;
            }
        }

        return ans;
    }
}