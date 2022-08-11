class Solution {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> targets = new HashMap<>();
		LinkedList<String> route = new LinkedList<String>();
		Stack<String> stack = new Stack<>();

		for (var ticket : tickets)
			targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).add(ticket.get(1));

		stack.push("JFK");

		while (!stack.empty()) {

			while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
				stack.push(targets.get(stack.peek()).poll());

			route.addFirst(stack.pop());
		}

		return route;
	}
}