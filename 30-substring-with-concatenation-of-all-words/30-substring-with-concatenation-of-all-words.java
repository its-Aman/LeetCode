class Solution {
	int wordLen;
	int totaWordlLen;

	public List<Integer> findSubstring(String S, String[] words) {
		LinkedList<Integer> ans = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();

		this.wordLen = words[0].length();
		this.totaWordlLen = wordLen * words.length;

		for (String word : words)
			map.put(word, 1 + map.getOrDefault(word, 0));

		for (int i = 0; i <= S.length() - this.totaWordlLen; i++)
			if (this.helper(i, S, new HashMap<>(map)))
				ans.add(i);
		return ans;
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