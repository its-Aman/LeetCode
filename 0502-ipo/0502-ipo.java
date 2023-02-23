class Solution {
    public int findMaximizedCapital(int K, int W, int[] profits, int[] capital) {
        int N = capital.length;
        int[][] zip = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            zip[i] = new int[] {capital[i], profits[i]};
        }
        
        Arrays.sort(zip, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(N, Collections.reverseOrder());
        int i = 0;
        
        while(K > 0) {
            while(i < N && W >= zip[i][0]) {
                pq.offer(zip[i++][1]);
            }

            if(pq.isEmpty()) {
                break;
            }
            
            W += pq.poll();
            K--;
        }
        
        return W;
    }
}