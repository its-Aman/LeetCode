class Solution {
	LinkedList<String> res = new LinkedList<>();

	Map<String, Queue<String>> graph = new HashMap<>();
	Map<String, Integer> out = new HashMap<>();

	public List<String> findItinerary(List<List<String>> tickets) {

		for (var ticket : tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);

			this.out.put(from, 1 + this.out.getOrDefault(from, 0));

			this.graph.putIfAbsent(from, new PriorityQueue<>());
			this.graph.get(from).offer(to);
		}

		this.dfs("JFK");

		return this.res;
	}

	private void dfs(String at) {

		while (this.out.getOrDefault(at, 0) != 0) {
			this.out.put(at, this.out.get(at) - 1);

			String next = this.graph.get(at).poll();
			this.dfs(next);
		}

		this.res.addFirst(at);
	}
}