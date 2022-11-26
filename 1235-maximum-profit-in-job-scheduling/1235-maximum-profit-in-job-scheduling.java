class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        return jobScheduling_dp(startTime, endTime, profit);
    }
    
    public int jobScheduling_dp(int[] startTime, int[] endTime, int[] profit) {
        int N = profit.length;
        
        // bubble sort
        for(int i = 0; i < N; i++) {
            int s = startTime[i],
                e = endTime[i],
                p = profit[i];
            int j = i - 1;
            
            while(j >= 0 && endTime[j] > e) {
                startTime[j + 1] = startTime[j];
                endTime[j + 1] = endTime[j];
                profit[j + 1] = profit[j];
                j--;
            }

            startTime[j + 1] = s;
            endTime[j + 1] = e;
            profit[j + 1] = p;
        }
        
        int[] max = new int[N];
        max[0] = profit[0];
        
        for(int i = 1; i < N; i++) {
            int prev = i - 1;
            int s = startTime[i],
                p = profit[i];
            
            if(endTime[prev] > s) {
                while(prev >= 0 && endTime[prev] > s)
                    prev--;
                
                // perform knapsack/dp/greedy
                if(prev >= 0)
                    max[i] = Math.max(max[i-1], p + max[prev]);
                else
                    max[i] = Math.max(max[i-1], p);
            } else {
                max[i] = max[prev] + p;
            }
        }
        
        return max[N-1];
    }
    
    public int jobScheduling_TreeMap(int[] startTime, int[] endTime, int[] profit) {
        int N = profit.length;
        int[][] jobs = new int[N][3];

        for (int i = 0; i < N; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};

        Arrays.sort(jobs, Comparator.comparingInt(j -> j[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int currProfit = job[2] + dp.floorEntry(job[0]).getValue();
            if (currProfit > dp.lastEntry().getValue())
                dp.put(job[1], currProfit);
        }

        return dp.lastEntry().getValue();
    }

}