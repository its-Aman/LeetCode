class Solution {

	public int[][] merge(int[][] intervals) {
		int N = intervals.length;

		ArrayList<ArrayList<Integer>> mergeIntervals = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		for (int i = 1; i <= N; i++) {
			Integer start = intervals[i - 1][0];
			Integer end = intervals[i - 1][1];

			while (i < N && (start <= intervals[i][0] && intervals[i][0] <= end)) {
				end = Math.max(end, intervals[i][1]);
				i += 1;
			}

			ArrayList<Integer> mergeInterval = new ArrayList<Integer>();
			mergeInterval.add(start);
			mergeInterval.add(end);
			mergeIntervals.add(mergeInterval);
		}

		int[][] ans = mergeIntervals.stream().map(i -> i.stream().mapToInt(point -> point).toArray())
				.toArray(int[][]::new);

		return ans;
	}
}