class Solution {
    
	public boolean isPossible(int[] nums) {
		int pre = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
		int curr = 0, cnt = 0, c1 = 0, c2 = 0, c3 = 0;
		int i = 0, N = nums.length;

		while (i < N) {

			curr = nums[i];
			cnt = 0;

			while (i < N && curr == nums[i]) {
				cnt += 1;
				i += 1;
			}

			if (curr != pre + 1) {
				if (p1 != 0 || p2 != 0)
					return false;

				c1 = cnt;
				c2 = 0;
				c3 = 0;
			} else {
				if (cnt < p1 + p2)
					return false;

				c1 = Math.max(0, cnt - (p1 + p2 + p3));
				c2 = p1;
				c3 = p2 + Math.min(p3, cnt - (p1 + p2));

			}

			pre = curr;
			p1 = c1;
			p2 = c2;
			p3 = c3;
		}

		return (p1 == 0 && p2 == 0);
	}
}