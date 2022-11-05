class Solution {
    TrieNode root;
    int[][] nbrs;
    char[][] board;
    List<String> ans;
    int R, C;

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        this.board = board;
        R = board.length;
        C = board[0].length;
        ans = new ArrayList<>();
        nbrs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (String word : words)
            insert(word);

        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                backtrack("", root, r, c);

        return ans;
    }

    private void backtrack(String currWord, TrieNode node, int r, int c) {
        if (node.isEnd) {
            ans.add(currWord);
            node.isEnd = false;
        }

        if (r < 0 || r >= R || c < 0 || c >= C)
            return;

        char ch = board[r][c];

        if (ch == '#')
            return;

        node = node.next[ch - 'a'];

        if (node == null)
            return;

        board[r][c] = '#';

        String newWord = currWord + String.valueOf(ch);

        for (int[] nbr : nbrs)
            backtrack(newWord, node, r + nbr[0], c + nbr[1]);

        board[r][c] = ch;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null)
                node.next[c - 'a'] = new TrieNode();

            node = node.next[c - 'a'];
        }

        node.isEnd = true;
    }


    static class TrieNode {
        boolean isEnd;
        TrieNode[] next;

        TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
}
