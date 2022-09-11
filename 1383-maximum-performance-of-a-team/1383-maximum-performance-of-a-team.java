class Solution {
    public int maxPerformance(int N, int[] S, int[] E, int K) {
        int[][] grouped = new int[N][2];

        for (int i = 0; i < N; i++)
            grouped[i] = (new int[]{E[i], S[i]});

        // sort engg. by their efficiency in decreasing order
        Arrays.sort(grouped, (e1, e2) -> e2[0] - e1[0]);
        
        // will keep track of the engg. with least speed
        PriorityQueue<Integer> pq = new PriorityQueue<>(K, (e1, e2) -> e1 - e2);

        long ans = 0, sum = 0;

        for (int[] currEngg : grouped) {
            // let's add the engineer to our team
            pq.add(currEngg[1]);
            
            // what's the current team speed?
            sum += currEngg[1];

            // do we need to layoff?
            if (pq.size() > K)
                // let's say goodbye to least speedy engg
                sum -= pq.poll();
            
            // is team's performance increased?
            // if so, let's take welcome that engg.
            ans = Math.max(ans, sum * currEngg[0]);
        }

        // returning the ans with MOD !
        return (int) (ans % (long) (1e9 + 7));
    }
}