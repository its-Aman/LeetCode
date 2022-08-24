class Solution {
	public List<String> topKFrequent(String[] words, int K) {
		Map<String, Integer> map = new HashMap<>();
		int i = 0;

		for (String word : words)
			if (!map.containsKey(word))
				map.put(word, i++);

		int[] freq = new int[i + 1];

		for (String word : words)
			freq[map.get(word)] += 1;

		Queue<Pair<String, Integer>> q = new PriorityQueue<>((Pair<String, Integer> p1, Pair<String, Integer> p2) -> {
			if (p2.getValue() != p1.getValue())
				return p2.getValue() - p1.getValue();
			else
				return p1.getKey().compareTo(p2.getKey());
		});

		for (String word : map.keySet())
			q.offer(new Pair<>(word, freq[map.get(word)]));

		List<String> ans = new ArrayList<>();

		while (K-- > 0)
			ans.add(q.poll().getKey());

		return ans;
	}
}