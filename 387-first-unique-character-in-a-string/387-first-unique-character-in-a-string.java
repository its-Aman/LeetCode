class Solution {
	public int firstUniqChar(String S) {
		int max = S.length();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			int idx = S.indexOf(ch);

			if (idx != -1 && idx == S.lastIndexOf(ch))
				max = Math.min(max, idx);
		}

		return max == S.length() ? -1 : max;
	}
}