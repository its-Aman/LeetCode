class Solution {

	public int[][] merge(int[][] intervals) {
		int N = intervals.length;

		ArrayList<int[]> mergeIntervals = new ArrayList<>();

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		for (int i = 1; i <= N; i++) {
			int start = intervals[i - 1][0];
			int end = intervals[i - 1][1];

			while (i < N && (start <= intervals[i][0] && intervals[i][0] <= end)) {
				end = Math.max(end, intervals[i][1]);
				i += 1;
			}

			mergeIntervals.add(new int[] { start, end });
		}

		return mergeIntervals.toArray(new int[0][]);
	}
}