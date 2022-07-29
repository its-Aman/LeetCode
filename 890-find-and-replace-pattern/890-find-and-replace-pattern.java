class Solution {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> ans = new ArrayList<>();
		String NormalizedP = this.normalize(pattern);

		for (String word : words) {
//			if (this.match(word, pattern)) {
//				ans.add(word);
//			}
			if (NormalizedP.equals(this.normalize(word)))
				ans.add(word);
		}

		return ans;
	}

	public String normalize(String word) {
		Map<Character, Character> map = new HashMap<>();
    char ch = 'a';
		String ans = "";

		for (char w : word.toCharArray()) {
			map.putIfAbsent(w, ch++);
			ans = ans + map.get(w);
    }


		return ans;
	}
  
  public boolean match(String W, String P) {
    Map<String, String> w_2_p = new HashMap<>();
    Map<String, String> p_2_w = new HashMap<>();
    
    for(int i = 0; i < W.length(); i++) {
      
      String w = "" + W.charAt(i);
      String p = "" + P.charAt(i);

			if ((w_2_p.containsKey(w) && !w_2_p.get(w).equals(p)) || (p_2_w.containsKey(p) && !p_2_w.get(p).equals(w))) {
				return false;
			} else {
				w_2_p.put(w, p);
				p_2_w.put(p, w);
			}
		}
		
    return true;
  }
}