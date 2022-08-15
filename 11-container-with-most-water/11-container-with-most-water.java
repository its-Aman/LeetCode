class Solution {
	public int maxArea(int[] height) {
		int area = 0;
		int N = height.length;
		int lo = 0, hi = N - 1;

		while (lo < hi) {
			int currArea = (hi - lo) * Math.min(height[lo], height[hi]);
			area = Math.max(area, currArea);

			if (height[lo] < height[hi]) {
				int currLo = height[lo];

				while (lo < hi && currLo >= height[lo])
					lo += 1;
			} else {
				int currHi = height[hi];

				while (lo < hi && currHi >= height[hi])
					hi -= 1;
			}
		}

		return area;
	}
}