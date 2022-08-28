class Solution {
	public int[][] diagonalSort(int[][] M) {
		int R = M.length, C = M[0].length;
		int[][] ans = new int[R][C];

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				map.computeIfAbsent(r - c, k -> new ArrayList<>()).add(M[r][c]);

		for (List<Integer> l : map.values())
			Collections.sort(l);

		for (int r = R - 1; r >= 0; r--) {
			for (int c = C - 1; c >= 0; c--) {
				var l = map.get(r - c);
				ans[r][c] = l.get(l.size() - 1);
				l.remove(l.size() - 1);
			}
		}

		return ans;
	}

}