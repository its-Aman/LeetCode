class Solution {

    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> palindromePairs(String[] words) {
        int N = words.length;

        if (N < 2)
            return ans;

        TrieNode root = new TrieNode();

        for (int i = 0; i < N; i++)
            addWord(root, words[i], i);

        for (int i = 0; i < N; i++)
            searchWord(root, words[i], i);

        return ans;
    }

    private void searchWord(TrieNode root, String word, int i) {
        for (int j = 0; j < word.length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(word, j, word.length() - 1))
                ans.add(Arrays.asList(i, root.index));

            root = root.next[word.charAt(j) - 'a'];
            if (root == null)
                return;
        }

        for (int j : root.list) {
            if (i == j)
                continue;

            ans.add(Arrays.asList(i, j));
        }
    }

    private void addWord(TrieNode root, String word, int idx) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null)
                root.next[j] = new TrieNode();

            if (isPalindrome(word, 0, i))
                root.list.add(idx);

            root = root.next[j];
        }
        root.list.add(idx);
        root.index = idx;
    }


    private boolean isPalindrome(String word, int l, int h) {
        while (l < h)
            if (word.charAt(l++) != word.charAt(h--))
                return false;
        return true;
    }

    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    
}