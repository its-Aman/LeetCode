class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] ans = new int[N];
        int hottest = 0;
        
        for(int currDay = N - 1; currDay >= 0; currDay--) {
            int currTemp = temperatures[currDay];

            if(currTemp >= hottest) {
                hottest = currTemp;
                continue;
            }
            
            int nextHotterDay = 1;
            while(temperatures[currDay + nextHotterDay] <= currTemp)
                nextHotterDay += ans[currDay + nextHotterDay];
            
            ans[currDay] = nextHotterDay;
        }
        
        return ans;
    }
}