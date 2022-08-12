class Solution {
	public int myAtoi(String s) {
		s = s.trim();

		if (s.length() == 0)
			return 0;

		char first = s.charAt(0);
		int start = 0;
		int sign = 1;
		long sum = 0;

		if (first == '-') {
			sign = -1;
			start += 1;
		} else if (first == '+') {
			start += 1;
		}

		for (int i = start; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (!Character.isDigit(curr))
				return (int) sum * sign;

			sum = sum * 10 + (curr - '0');

			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;

			if (sign == -1 && sign * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}
}