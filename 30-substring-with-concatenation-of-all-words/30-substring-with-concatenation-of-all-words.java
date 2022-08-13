class Solution {
	int wordCount;
	int wordLen;
	int totaWordlLen;
	Map<String, Integer> map;

	public List<Integer> findSubstring(String S, String[] words) {
		LinkedList<Integer> ans = new LinkedList<>();
		this.map = new HashMap<>();
		this.wordCount = words.length;
		this.wordLen = words[0].length();
		this.totaWordlLen = this.wordLen * this.wordCount;

		for (String word : words)
			map.put(word, 1 + map.getOrDefault(word, 0));

		for (int i = 0; i < S.length() - this.totaWordlLen + 1; i++) {
			if (this.slidingWindow(i, S))
			// if (this.helper(i, S, new HashMap<>(this.map)))
				ans.add(i);
		}

		return ans;
	}

	private boolean slidingWindow(int start, String S) {
		final Map<String, Integer> seen = new HashMap<String, Integer>();
		int j = 0;

		while (j < this.wordCount) {
			String word = S.substring(start + j * this.wordLen, start + (j + 1) * this.wordLen);

			if (!this.map.containsKey(word))
				break;

			seen.put(word, seen.getOrDefault(word, 0) + 1);

			if (seen.get(word) > this.map.getOrDefault(word, 0))
				break;

			j += 1;
		}

		return j == this.wordCount;
	}

	private boolean helper(int start, String S, Map<String, Integer> localHashTable) {
		int i = 0;
		while (i < this.totaWordlLen) {
			String curr = S.substring(i + start, i + start + this.wordLen);
			if (!localHashTable.containsKey(curr) || localHashTable.get(curr) == 0) {
				return false;
			} else {
				i += this.wordLen;
				localHashTable.put(curr, localHashTable.get(curr) - 1);
			}
		}

		return true;
	}

}
