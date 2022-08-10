class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        // return this.networkDelayTime_Dijkstra(times, N, K);
        // return this.networkDelayTime_BellmanFord(times, N, K);
        return this.networkDelayTime_Floyd_Warshall(times, N, K);
    }
    
    public int networkDelayTime_Floyd_Warshall(int[][] times, int N, int K) {
        long[][] dist = new long[N][N];

        Stream.of(dist).forEach((long[] row) -> Arrays.fill(row, Integer.MAX_VALUE));

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            dist[u-1][v-1] = w;
        }
        
        for(int i = 0; i < N; i++)
            dist[i][i] = 0;
        
        for(int k = 0; k < N; k++)
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);

        long ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++) {
            if(dist[K - 1][i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[K - 1][i]);
        }
        return (int)ans;
    }

    public int networkDelayTime_BellmanFord(int[][] times, int N, int K) {
        this.dist = new int[N + 1];
        Arrays.fill(this.dist, Integer.MAX_VALUE);

        this.dist[K] = 0;
        
        for(int i = 0; i <= N; i++) {
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                if(this.dist[u] != Integer.MAX_VALUE && this.dist[v] > this.dist[u] + w)
                    this.dist[v] = this.dist[u] + w;
            }
        }
        
		int ans = 0;
		this.dist[0] = 0;

        for (int d : this.dist)
			ans = Math.max(ans, d);

		return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    
	Map<Integer, List<Pair<Integer, Integer>>> adj;
	int[] dist;
	boolean[] visited;
	Queue<Pair<Integer, Integer>> pq;

	private void buildAdj(int[][] times) {
		this.adj = new HashMap<>();

		for (int[] time : times) {
			int u = time[0];
			int v = time[1];
			int w = time[2];

			if (!this.adj.containsKey(u))
				this.adj.put(u, new LinkedList<>());

			this.adj.get(u).add(new Pair<>(v, w));
		}
	}

	public int networkDelayTime_Dijkstra(int[][] times, int N, int K) {
		this.buildAdj(times);
		this.visited = new boolean[N + 1];
		this.dist = new int[N + 1];
		this.pq = new PriorityQueue<Pair<Integer, Integer>>(
				(Pair<Integer, Integer> x, Pair<Integer, Integer> y) -> x.getValue() - y.getValue());
		Arrays.fill(dist, Integer.MAX_VALUE);

		this.pq.offer(new Pair<>(K, 0));
		this.dist[K] = 0;

		while (!pq.isEmpty()) {
			var node = pq.poll();

			this.visited[node.getKey()] = true;

			if (this.dist[node.getKey()] < node.getValue() || !this.adj.containsKey(node.getKey()))
				continue;

			for (var nbr : this.adj.get(node.getKey())) {
				if (this.visited[nbr.getKey()])
					continue;

				if (this.dist[nbr.getKey()] > this.dist[node.getKey()] + nbr.getValue()) {
					this.dist[nbr.getKey()] = this.dist[node.getKey()] + nbr.getValue();
					pq.offer(new Pair<>(nbr.getKey(), this.dist[nbr.getKey()]));
				}

			}
		}

		int ans = 0;
		this.dist[0] = 0;
		for (int d : this.dist)
			ans = Math.max(ans, d);

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}