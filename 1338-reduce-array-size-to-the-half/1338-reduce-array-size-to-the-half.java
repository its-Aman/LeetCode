class Solution {

    public int minSetSize(int[] arr) {
		int N = arr.length;
		int ans = 0;
		int half = 0;

		Map<Integer, Integer> occ = new HashMap<>();
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
				(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> p2.getValue() - p1.getValue());

		for (int item : arr)
			occ.put(item, 1 + occ.getOrDefault(item, 0));

		for (Map.Entry<Integer, Integer> item : occ.entrySet())
			pq.offer(new Pair<Integer, Integer>(item.getKey(), item.getValue()));

		while (!pq.isEmpty()) {
			Pair<Integer, Integer> curr = pq.poll();
			half += curr.getValue();
			ans += 1;

			if (half >= N / 2)
				return ans;
		}

		return -1;
	}

}