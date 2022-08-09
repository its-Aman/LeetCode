// https://leetcode.com/problems/partition-equal-subset-sum/discuss/462699/Whiteboard-Editorial.-All-Approaches-explained.

// https://leetcode.com/problems/partition-equal-subset-sum/discuss/1624939/C%2B%2BPython-5-Simple-Solutions-w-Explanation-or-Optimization-from-Brute-Force-to-DP-to-Bitmask

import java.math.BigInteger;

class Solution {
    public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if ((sum & 1) == 1)
			return false;

		String one = "1";
		BigInteger bit = new BigInteger(one).shiftLeft(sum >> 1);

		for (int num : nums) {
			bit = bit.or(bit.shiftRight(num));
		}

		return bit.testBit(0);
    }
}