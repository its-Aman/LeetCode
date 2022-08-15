class Solution {
	public List<Integer> findMinHeightTrees(int N, int[][] edges) {

		if (N == 1)
			return Collections.singletonList(0);

		List<Set<Integer>> adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++)
			adjList.add(new HashSet<Integer>());

		for (int[] edge : edges) {
			int n1 = edge[0], n2 = edge[1];
			adjList.get(n1).add(n2);
			adjList.get(n2).add(n1);
		}

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < N; i++)
			if (adjList.get(i).size() == 1)
				ans.add(i);

		while (N > 2) {
			N -= ans.size();
			List<Integer> curr = new ArrayList<>();

			for (int i : ans) {
				int j = adjList.get(i).iterator().next();
				adjList.get(j).remove(i);

				if (adjList.get(j).size() == 1)
					curr.add(j);
			}

			ans = curr;
		}

		return ans;
	}
}