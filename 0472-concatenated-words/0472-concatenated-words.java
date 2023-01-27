class Solution {
    Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (String w : words) {
            int N = w.length();
            min = Math.min(min, N);

            if (N > 0) {
                set.add(w);
            }
        }

        for (String w : words) {
            if (dfs(w, 0, w.length(), min)) {
                ans.add(w);
            }
        }

        return ans;
    }

    private boolean dfs(String word, int start, int end, int min) {

        for (int i = start + min; i <= end - min; i++) {
            if (set.contains(word.substring(start, i)) &&
                    (set.contains(word.substring(i, end)) || dfs(word, i, end, min))) {
                return true;
            }
        }

        return false;
    }
}