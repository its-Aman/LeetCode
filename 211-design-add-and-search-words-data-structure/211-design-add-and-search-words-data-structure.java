class WordDictionary {

	class TrieNode {
		public TrieNode[] next = new TrieNode[26];
		public boolean isEnd;
	}

	private TrieNode root;
	private int maxDepth = 0;
    
	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		this.maxDepth = Math.max(this.maxDepth, word.length());
		TrieNode curr = this.root;

		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				curr.next[c - 'a'] = new TrieNode();
			}
			curr = curr.next[c - 'a'];
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		if (word.isEmpty() || word.length() > this.maxDepth)
			return false;

		return this.search(word, this.root, 0);
	}

	public boolean search(String word, TrieNode curr, int startsAt) {
		boolean found = false;

		for (int i = startsAt; i < word.length(); i++) {
			if (word.charAt(i) == '.') {
				for (int j = 0; j < 26; j++) {
					if (curr.next[j] != null) {
						found = found || this.search(word, curr.next[j], i + 1);
					}
				}
                
				if (!found)
					return false;
				else
					break;
            } else {
				if (curr.next[word.charAt(i) - 'a'] == null)
					return false;

				curr = curr.next[word.charAt(i) - 'a'];
			}
		}

		return curr.isEnd || found;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */