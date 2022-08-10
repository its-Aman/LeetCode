class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        // return this.networkDelayTime_Dijkstra(times, N, K);
        return this.networkDelayTime_BellmanFord(times, N, K);
        // return this.networkDelayTime_Floyd_Warshall(times, N, K);
    }
    
	public int networkDelayTime_Floyd_Warshall(int[][] times, int N, int K) {
		long[][] dist = new long[N][N];

		Stream.of(dist).forEach((long[] row) -> Arrays.fill(row, Integer.MAX_VALUE));

		for (int[] time : times) {
			int u = time[0];
			int v = time[1];
			int w = time[2];

			dist[u - 1][v - 1] = w;
		}

		for (int i = 0; i < N; i++)
			dist[i][i] = 0;

		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

		long ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			if (dist[K - 1][i] == Integer.MAX_VALUE)
				return -1;

			ans = Math.max(ans, dist[K - 1][i]);
		}

		return (int) ans;
	}

	public int networkDelayTime_BellmanFord(int[][] times, int N, int K) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[K] = 0;

		for (int i = 0; i <= N; i++) {

			for (int[] time : times) {
				int u = time[0];
				int v = time[1];
				int w = time[2];

				if (dist[u] != Integer.MAX_VALUE) {
					dist[v] = Math.min(dist[v], dist[u] + w);
				}
			}

		}

		int ans = 0;
		dist[0] = 0;

		for (int d : dist) {
			if (d == Integer.MAX_VALUE)
				return -1;

			ans = Math.max(ans, d);
		}

		return ans;
	}

	public int networkDelayTime_Dijkstra(int[][] times, int N, int K) {
		Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(
				(Pair<Integer, Integer> x, Pair<Integer, Integer> y) -> x.getValue() - y.getValue());

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int[] time : times) {
			int u = time[0];
			int v = time[1];
			int w = time[2];

			if (!adj.containsKey(u))
				adj.put(u, new LinkedList<>());

			adj.get(u).add(new Pair<>(v, w));
		}

		pq.offer(new Pair<>(K, 0));
		dist[K] = 0;

		while (!pq.isEmpty()) {
			var node = pq.poll();

			visited[node.getKey()] = true;

			if (dist[node.getKey()] < node.getValue() || !adj.containsKey(node.getKey()))
				continue;

			for (var nbr : adj.get(node.getKey())) {
				if (visited[nbr.getKey()])
					continue;

				if (dist[nbr.getKey()] > dist[node.getKey()] + nbr.getValue()) {
					dist[nbr.getKey()] = dist[node.getKey()] + nbr.getValue();
					pq.offer(new Pair<>(nbr.getKey(), dist[nbr.getKey()]));
				}

			}
		}

		int ans = 0;
		dist[0] = 0;

		for (int d : dist) {
			if (d == Integer.MAX_VALUE)
				return -1;

			ans = Math.max(ans, d);
		}

		return ans;
	}
}