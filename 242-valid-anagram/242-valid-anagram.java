class Solution {
	public boolean isAnagram(String S, String T) {
		int[] dict = new int[26];

		for (int i = 0; i < S.length(); i++) {
			dict[S.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < T.length(); i++) {
			dict[T.charAt(i) - 'a'] -= 1;

			if (dict[T.charAt(i) - 'a'] < 0)
				return false;
		}

		for (int item : dict)
			if (item > 0)
				return false;

		return true;
	}
}