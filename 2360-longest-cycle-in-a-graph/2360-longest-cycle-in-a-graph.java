class Solution {
  
	public int longestCycle(int[] edges) {
		int res = -1;

		Pair<Integer, Integer>[] memo = new Pair[edges.length];

		Arrays.fill(memo, new Pair<Integer, Integer>(-1, -1));

		for (int i = 0; i < edges.length; i++) {

			for (int j = i, dist = 0; j != -1; j = edges[j]) {
				Pair<Integer, Integer> p = memo[j];

				if (p.getKey() == -1) {
					memo[j] = new Pair<Integer, Integer>(dist++, i);
				} else {
					if (p.getValue() == i) {
						res = Math.max(res, dist - p.getKey());
					}
					break;
				}
			}
		}

		return res;
	}
}