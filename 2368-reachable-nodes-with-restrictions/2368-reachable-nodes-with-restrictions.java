class Solution {
	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		int ans = 0;
		List<List<Integer>> adjList = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		for (int r : restricted)
			set.add(r);

		for (int i = 0; i < n; i++)
			adjList.add(i, new ArrayList<Integer>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}

		q.add(0);
		set.add(0);

		while (!q.isEmpty()) {

			int sz = q.size();

			while (sz-- > 0) {
				ans += 1;
				Integer curr = q.poll();
				for (int next : adjList.get(curr)) {
					if (set.add(next)) {
						q.add(next);
					}
				}
			}
		}

		return ans;
	}
}