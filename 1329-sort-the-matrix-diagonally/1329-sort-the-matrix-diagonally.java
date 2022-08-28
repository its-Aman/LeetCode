class Solution {
	public int[][] diagonalSort(int[][] M) {
		int R = M.length, C = M[0].length;
		int[][] ans = new int[R][C];

		Map<Integer, Queue<Integer>> map = new HashMap<>();

		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				map.computeIfAbsent(r - c, k -> new PriorityQueue<>()).add(M[r][c]);

		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				ans[r][c] = map.get(r - c).poll();

		return ans;
	}
}