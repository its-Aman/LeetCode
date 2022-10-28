class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            if (canForm(word, preWords))
                ans.add(word);

            preWords.add(word);
        }

        return ans;
    }

    private boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        int N = word.length();
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}