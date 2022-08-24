class Solution {
	public List<String> topKFrequent(String[] words, int K) {
		Map<String, Integer> map = new HashMap<>();

		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);

		Queue<Pair<String, Integer>> q = new PriorityQueue<>((Pair<String, Integer> p1, Pair<String, Integer> p2) -> {
			if (p2.getValue() != p1.getValue())
				return p1.getValue() - p2.getValue();
			else
				return p2.getKey().compareTo(p1.getKey());
		});

		for (String word : map.keySet()) {
			q.offer(new Pair<>(word, map.get(word)));

			if (q.size() > K)
				q.poll();
		}

		LinkedList<String> ans = new LinkedList<>();

		while (!q.isEmpty())
			ans.addFirst(q.poll().getKey());

		return ans;
	}
}