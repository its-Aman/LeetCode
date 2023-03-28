class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int N = days.length,
            lastDay = days[N-1];
        int[] dp = new int[lastDay+1];
        boolean[] daySet = new boolean[370];
        
        for(int day: days) {
            daySet[day] = true;
        }
        
        for(int day = 1; day < dp.length; day++) {
            if(daySet[day]) {
                int one = dp[Math.max(day-1,0)] + costs[0],
                    week = dp[Math.max(day-7,0)] + costs[1],
                    month = dp[Math.max(day-30,0)] + costs[2];
                dp[day] = Math.min(one, Math.min(week, month));
            } else {
                dp[day] = dp[day - 1];
            }
        }

        return dp[lastDay];
    }
}