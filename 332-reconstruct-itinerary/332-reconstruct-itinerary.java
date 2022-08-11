class Solution {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, Queue<String>> graph = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (var ticket : tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);

			graph.putIfAbsent(from, new PriorityQueue<>());
			graph.get(from).offer(to);
		}

		this.dfs("JFK", graph, list);
        
		Collections.reverse(list);

		return list;
	}

	private void dfs(String at, Map<String, Queue<String>> graph, List<String> list) {
		Queue<String> pq = graph.get(at);

		while (pq != null && !pq.isEmpty()) {
			String next = pq.poll();
			this.dfs(next, graph, list);
		}

		list.add(at);
	}
}