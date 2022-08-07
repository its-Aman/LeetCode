class Solution {
	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		int ans = 0;
		List<Integer>[] adjList = new ArrayList[n];

		for (int[] e : edges) {
			if (adjList[e[0]] == null) {
				adjList[e[0]] = new ArrayList<>();
			}
			adjList[e[0]].add(e[1]);

			if (adjList[e[1]] == null) {
				adjList[e[1]] = new ArrayList<>();
			}
			adjList[e[1]].add(e[0]);
		}

		Set<Integer> set = new HashSet<>();

		for (int dnd : restricted)
			set.add(dnd);

		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		set.add(0);

		while (!q.isEmpty()) {

			int sz = q.size();

			for (int i = 0; i < sz; i++) {
				ans += 1;
				int curr = q.poll();
				for (int next : adjList[curr]) {
					if (set.add(next)) {
						q.add(next);
					}
				}
			}
		}

		return ans;
	}
}