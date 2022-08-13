class Solution {

    public String longestPalindrome(String S) {
		String max = "";

		for (int i = 0; i < S.length(); i++) {
			String even = this.helper(i, i, S);
			String odd = this.helper(i, i + 1, S);

			if (even.length() > max.length())
				max = even;

			if (odd.length() > max.length())
				max = odd;
		}

		return max;
	}

	private String helper(int left, int right, String S) {
		String currMax = "";

		while (left >= 0 && right < S.length() && S.charAt(left) == S.charAt(right)) {

			if (right - left + 1 > currMax.length())
				currMax = S.substring(left, right + 1);
			left -= 1;
			right += 1;
		}

		return currMax;
	}


    
}