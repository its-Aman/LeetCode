class Solution {
	public long kSum(int[] nums, int K) {
		long sum = 0, minus = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += Math.max(nums[i], 0);
			nums[i] = Math.abs(nums[i]);
		}

		Arrays.sort(nums);

		Queue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

		minHeap.offer(new long[] { nums[0], 0 });

		while (--K > 0) {
			long[] top = minHeap.poll();
			long val = top[0];
			int i = (int) top[1];
			minus = val;

			if (i < nums.length - 1) {
				minHeap.offer(new long[] { val - nums[i] + nums[i + 1], i + 1 });
				minHeap.offer(new long[] { val + nums[i + 1], i + 1 });
			}
		}

		return sum - minus;
	}
}