class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0, score = 0, N = tokens.length;
        int l = 0, r = N - 1;
        
        Arrays.sort(tokens);

        while(l <= r) {
            if(power >= tokens[l]) {
                power -= tokens[l++];
                ans = Math.max(ans, ++score);
            } else if(score > 0) {
                power += tokens[r--];
                --score;     
            } else {
                break;
            }
        }        
        
        return ans;
    }
}