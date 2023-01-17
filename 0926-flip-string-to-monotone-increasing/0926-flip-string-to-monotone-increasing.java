class Solution {

    public int minFlipsMonoIncr(String s) {
        int ans = 0, ones = 0;
        
        for(char c: s.toCharArray()) {
            if(c == '0') {
                ans = Math.min(ans + 1, ones);
            } else {
                ones++;
            }
        }
        
        return ans;
    }
}