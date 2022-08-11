class Solution {

	LinkedList<String> res = new LinkedList<>();

	Map<String, List<String>> graph = new HashMap<>();
	Map<String, Integer> in = new HashMap<>();
	Map<String, Integer> out = new HashMap<>();

	Set<String> airports = new HashSet<>();

	List<List<String>> tickets;

	public List<String> findItinerary(List<List<String>> tickets) {
		this.tickets = tickets;
		this.preReq();
		this.findEulerianPath();

		return this.res;

//		if (this.res.size() == this.tickets.size())
//			return this.res;
//		else
//			return new LinkedList<>();
	}

	private void preReq() {
		for (var ticket : this.tickets) {
			this.graph.putIfAbsent(ticket.get(0), new LinkedList<>());
			this.graph.get(ticket.get(0)).add(ticket.get(1));

			this.airports.add(ticket.get(0));
			this.airports.add(ticket.get(1));
		}

		for (String key : this.graph.keySet()) {
			Collections.sort(this.graph.get(key), Comparator.reverseOrder());
		}
	}

	private void countDegrees() {
		for (var ticket : this.tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);

			this.in.put(to, 1 + this.in.getOrDefault(to, 0));
			this.out.put(from, 1 + this.out.getOrDefault(from, 0));
		}
	}

	private boolean hasEulerianPath() {
		int startNodes = 0;
		int endNodes = 0;

		for (String airport : this.airports) {
			if ((this.out.getOrDefault(airport, 0) - this.in.getOrDefault(airport, 0) > 1)
					|| (this.in.getOrDefault(airport, 0) - this.out.getOrDefault(airport, 0) > 1))
				return false;
			else if (this.out.getOrDefault(airport, 0) - this.in.getOrDefault(airport, 0) == 1)
				startNodes += 1;
			else if (this.in.getOrDefault(airport, 0) - this.out.getOrDefault(airport, 0) == 1)
				endNodes += 1;
		}

		return ((endNodes == 0 && startNodes == 0) || (endNodes == 1 && startNodes == 1));
	}

	private String findStartingNode() {
		String start = "JFK";

		for (String airport : this.airports) {

			if (this.out.get(airport) - this.in.get(airport) == 1)
				return airport;

			if (this.out.get(airport) > 0)
				start = airport;
		}

		return start;
	}

	private void dfs(String at) {

		while (this.out.getOrDefault(at, 0) != 0) {
			this.out.put(at, this.out.get(at) - 1);

			String next = this.graph.get(at).get(this.out.get(at));
			this.dfs(next);
		}

		this.res.addFirst(at);
	}

	private void findEulerianPath() {
		this.countDegrees();

//		boolean isEulerPathPresent = this.hasEulerianPath();
//
//		if (!isEulerPathPresent)
//			return;

		this.dfs("JFK");

	}
}    