class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> map = new HashMap<>();

		for (String str : strs)
			map.computeIfAbsent(this.computeCommonHash(str), k -> new ArrayList<>()).add(str);

		return List.copyOf(map.values());
	}

	private int computeCommonHash(String str) {
		int[] hash = new int[26];

		for (char c : str.toCharArray())
			hash[c - 'a'] += 1;

		return Arrays.hashCode(hash);
	}
}