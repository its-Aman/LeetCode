class Solution {
    public int minOperations(int N) {
        int ans = 0;
        
        while (N > 0) {
            int max = 1;

            while (max <= N) {
                max <<= 1;
            }
            
            int min = max >> 1;
            N = Math.min(N - min, max - N);
            ans++;
        }

        return ans;
    }
}