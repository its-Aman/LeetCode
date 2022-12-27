class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int N = rocks.length;
        int[] diff = new int[N];
        int ans = 0;
        
        for(int i = 0; i < N; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        
        Arrays.sort(diff);
        
        // System.out.println(Arrays.toString(diff));
        
        for(int i = 0; i < N; i++) {
            additionalRocks -= diff[i];
            
            if(additionalRocks < 0) {
                return ans;
            }
            ans++;
        }
        
        return ans;
    }
}