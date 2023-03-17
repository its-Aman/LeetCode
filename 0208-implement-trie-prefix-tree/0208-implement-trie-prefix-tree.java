class TrieNode {
    boolean done;
    TrieNode[] next;
    
    public TrieNode() {
        done = false;
        next = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for(char c: word.toCharArray()) {
            if(node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            
            node = node.next[c - 'a'];
        }
        
        node.done = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        
        for(char c: word.toCharArray()) {
            if(node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        
        return node.done;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        
        for(char c: prefix.toCharArray()) {
            if(node.next[c - 'a'] == null) {
                return false;
            }
            
            node = node.next[c - 'a'];
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