class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count;
    }
    
    public int countPairs(int[] nums, int low, int high) {
        TrieNode root = new TrieNode();
        int count = 0;
        
        for (int num : nums) {
            count += getCount(root, num, high + 1) - getCount(root, num, low);
            insert(root, num);
        }
        
        return count;
    }
    
    private void insert(TrieNode root, int num) {
        TrieNode node = root;
        
        for (int i = 14; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            
            node = node.children[bit];
            node.count++;
        }
    }
    
    private int getCount(TrieNode root, int num, int limit) {
        TrieNode node = root;
        int count = 0;
        
        for (int i = 14; i >= 0 && node != null; i--) {
            int bit = (num >> i) & 1;
            int limitBit = (limit >> i) & 1;
            
            if (limitBit == 1) {
                if (node.children[bit] != null) {
                    count += node.children[bit].count;
                }
                
                node = node.children[1 - bit];
            } else {
                node = node.children[bit];
            }
        }
        
        return count;
    }
}
