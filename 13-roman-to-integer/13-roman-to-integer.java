class Solution {
	public int romanToInt(String S) {
		int N = S.length();
		int ans = 0;

		for (int i = 0; i < N; i++) {
			char curr = S.charAt(i);
			boolean inRange = i + 1 < N;

			switch (curr) {
			case 'I':
				if (inRange && S.charAt(i + 1) == 'V') {
					ans += 4;
					i += 1;
				} else if (inRange && S.charAt(i + 1) == 'X') {
					ans += 9;
					i += 1;
				} else {
					ans += 1;
				}
				break;

			case 'V':
				ans += 5;
				break;

			case 'X':
				if (inRange && S.charAt(i + 1) == 'L') {
					ans += 40;
					i += 1;
				} else if (inRange && S.charAt(i + 1) == 'C') {
					ans += 90;
					i += 1;
				} else {
					ans += 10;
				}
				break;

			case 'L':
				ans += 50;
				break;

			case 'C':
				if (inRange && S.charAt(i + 1) == 'D') {
					ans += 400;
					i += 1;
				} else if (inRange && S.charAt(i + 1) == 'M') {
					ans += 900;
					i += 1;
				} else {
					ans += 100;
				}
				break;

			case 'D':
				ans += 500;
				break;

			case 'M':
				ans += 1000;
				break;

			default:
				System.out.println("Invalid input: " + curr);
			}
		}

		return ans;
	}
}