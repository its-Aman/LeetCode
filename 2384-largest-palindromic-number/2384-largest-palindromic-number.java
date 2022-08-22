class Solution {
	public String largestPalindromic(String num) {
		int mid = -1;
		boolean flag = true;
		int[] freq = new int[10];

		StringBuilder sb = new StringBuilder();

		for (char n : num.toCharArray())
			freq[n - '0'] += 1;

		for (int i = 9; i >= 0; i--) {
			if (freq[i] % 2 == 1 && flag) {
				mid = i;
				flag = false;
			}

			if (i == 0 && sb.length() == 0)
				break;

			int n = freq[i] / 2;

			while (n-- > 0)
				sb.append(i);
		}

//		System.out.println(sb);
		String ans = "";
		if (mid != -1) {
			String pre = sb.toString();
			sb.reverse();
			String post = sb.toString();
			ans = pre.concat(Integer.toString(mid).concat(post));
		} else {
			ans = sb.toString().concat(sb.reverse().toString());
		}

		return ans.length() == 0 ? "0" : ans;
	}
}