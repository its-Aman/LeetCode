class Solution {
    public int countOdds(int low, int high) {
        int ans = 0;
        int N = high - low - 1;
                
        ans = (low % 2) + (high % 2);
        
        if(N == 0) {
            return ans;
        }
        
        if(N == -1) {
            return low % 2;
        }

        if(ans == 0) {
            ans += (N / 2) + 1;
        } else {
            ans += (N / 2);
        }
    
        return ans;
    }
}