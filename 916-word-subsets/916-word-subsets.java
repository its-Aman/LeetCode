class Solution {
	public List<String> wordSubsets(String[] words1, String[] words2) {
		List<String> ans = new ArrayList<>();
		int[] map = this.buildUniqueString(words2);

		for (String word : words1) {
			int[] clonedMap = map.clone();

			for (char s : word.toCharArray()) {
				if (clonedMap[s - 'a'] > 0)
					clonedMap[s - 'a'] -= 1;
			}

			boolean isAdd = true;

			for (int i = 0; i < 26; i++) {
				if (clonedMap[i] > 0) {
					isAdd = false;
				}
			}

			if (isAdd)
				ans.add(word);
		}

		return ans;
	}

	public int[] buildUniqueString(String[] words) {
		int[] ans = new int[26];

		for (String word : words) {
			int[] temp = new int[26];

			for (char ch : word.toCharArray()) {
				temp[ch - 'a'] += 1;
			}

			for (int i = 0; i < 26; i++) {
				ans[i] = Math.max(ans[i], temp[i]);
			}
		}

		return ans;
	}

}