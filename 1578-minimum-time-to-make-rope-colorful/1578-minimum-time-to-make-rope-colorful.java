class Solution {
    public int minCost(String colors, int[] neededTime) {
        // return minCost_singlePass(colors, neededTime);
        return minCost_2Pointer(colors, neededTime);
    }

    public int minCost_singlePass(String colors, int[] neededTime) {
        int N = neededTime.length;
        int totalTime = 0, currMaxTime = 0;

        for(int i = 0; i < N; i++) {
            if(i > 0 && colors.charAt(i) != colors.charAt(i - 1))
                currMaxTime = 0;
            
            totalTime += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        
        return totalTime;
    }
    
    public int minCost_2Pointer(String colors, int[] neededTime) {
        int N = neededTime.length;
        int ans = 0;
        int l = 0; 
        
        while(l < N) {
            int currTotal = 0, currMax = 0;
            int r = l;
            
            while(r < N && colors.charAt(l) == colors.charAt(r)) {
                currTotal += neededTime[r];
                currMax = Math.max(currMax, neededTime[r]);
                r++;
            }
            
            ans += currTotal - currMax;
            l = r;
        }
        
        return ans;
    }
}