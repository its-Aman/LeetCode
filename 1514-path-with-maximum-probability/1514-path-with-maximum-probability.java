class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Double>[] graph = new Map[n];

        for(int i=0; i<n; i++) graph[i] = new HashMap<>();
        
        for(int i=0; i<edges.length; i++) {
            int a=edges[i][0], b=edges[i][1];
            double p = succProb[i];

            graph[a].put(b, p);
            graph[b].put(a, p);
        }
        
        double[] prob = new double[n];
        prob[start] = 1.0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -prob[i]));
        pq.offer(start);
        
        while(!pq.isEmpty()) {
            var curr = pq.poll();
            // if(curr == end) return prob[end];
            
            for(int next: graph[curr].keySet()) {
                double edgeProb = graph[curr].get(next);
                
                if(prob[curr] * edgeProb > prob[next]) {
                    prob[next] = edgeProb * prob[curr];
                    pq.offer(next);
                }
            }
        }
        
        return prob[end];
    }
}