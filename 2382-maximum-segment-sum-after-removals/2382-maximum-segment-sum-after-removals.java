class Solution {
	private long[] ds;

	public long[] maximumSegmentSum(int[] nums, int[] rq) {
		int N = nums.length;
		long[] ans = new long[N];
		ds = new long[N];

		Arrays.fill(ds, Integer.MAX_VALUE);

		for (int i = rq.length - 1; i > 0; --i) {
			int j = rq[i];

			ds[j] = -nums[j];

			if (j > 0 && ds[j - 1] != Integer.MAX_VALUE)
				this.merge(j, j - 1);

			if (j < N - 1 && ds[j + 1] != Integer.MAX_VALUE)
				this.merge(j, j + 1);

			ans[i - 1] = Math.max(ans[i], -ds[this.find(j)]);
		}

		return ans;
	}

	private void merge(int i, int j) {
		int ii = this.find(i);
		int jj = this.find(j);

		this.ds[jj] += this.ds[ii];
		this.ds[ii] = jj;
	}

	private int find(int i) {

		if (this.ds[i] < 0)
			return i;
		else
			return (int) (this.ds[i] = this.find((int) this.ds[i]));
	}
}