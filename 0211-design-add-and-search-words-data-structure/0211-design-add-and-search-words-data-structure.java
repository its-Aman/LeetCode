class TrieNode {
    boolean done;
    TrieNode[] next;
    
    TrieNode() {
        done = false;
        next = new TrieNode[26];
    }
}

class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
        var curr = root;
        
        for(char c: word.toCharArray()) {
            if(curr.next[c-'a'] == null) {
                curr.next[c-'a'] = new TrieNode();
            }
            
            curr = curr.next[c-'a'];
        }
        
        curr.done = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int idx, TrieNode node) {
        if(idx == word.length()) {
            return node.done;
        }
        char c = word.charAt(idx);
        
        if(c == '.') {
            for(var nextNode: node.next) {
                if(nextNode != null && searchHelper(word, idx + 1, nextNode)) {
                    return true;
                }
            }
            
            return false;
        }
        
        if(node.next[c - 'a'] == null) {
            return false;
        }
        
        return searchHelper(word, idx + 1, node.next[c - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */