public class Trie {
  
  private class TrieNode {

    TrieNode[] next = new TrieNode[26];
    boolean isEnd = false;

    public TrieNode() { }

    public TrieNode(boolean isEnd) {
      this.isEnd = isEnd;
    }
    
  }
  
	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
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
		TrieNode curr = this.root;

		for (char c : word.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				return false;
			}
			curr = curr.next[c - 'a'];
		}

		return curr.isEnd;
	}

	public boolean startsWith(String prefix) {
		TrieNode curr = this.root;

		for (char c : prefix.toCharArray()) {
			if (curr.next[c - 'a'] == null) {
				return false;
			}
			curr = curr.next[c - 'a'];
		}

		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */