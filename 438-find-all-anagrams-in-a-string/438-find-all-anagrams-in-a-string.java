class Solution {

    public List<Integer> findAnagrams(String S, String P) {
		List<Integer> ans = new ArrayList<>();

		if (P.length() > S.length())
			return ans;

		Map<Character, Integer> pCount = new HashMap<>();
		Map<Character, Integer> sCount = new HashMap<>();

		for (int i = 0; i < P.length(); i++) {
			pCount.put(P.charAt(i), 1 + pCount.getOrDefault(P.charAt(i), 0));
			sCount.put(S.charAt(i), 1 + sCount.getOrDefault(S.charAt(i), 0));
		}

		for (int curr = 0; curr <= S.length() - P.length(); curr++) {
			int next = curr + P.length();

			if (pCount.equals(sCount))
				ans.add(curr);

			if (next < S.length())
				sCount.put(S.charAt(next), 1 + sCount.getOrDefault(S.charAt(next), 0));

			if (sCount.get(S.charAt(curr)) == 1)
				sCount.remove(S.charAt(curr));
			else
				sCount.put(S.charAt(curr), sCount.get(S.charAt(curr)) - 1);
		}

		return ans;
	}

    
}