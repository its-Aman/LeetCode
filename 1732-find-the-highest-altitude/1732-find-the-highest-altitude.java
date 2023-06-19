class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, curr = 0, prev = 0;
        
        for(int _gain: gain) {
            curr = _gain + prev;
            ans = Math.max(ans, curr);
            prev = curr;
        }
        
        return ans;
    }
}