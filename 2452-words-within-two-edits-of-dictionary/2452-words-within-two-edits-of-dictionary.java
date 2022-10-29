class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (query.length() != word.length()) continue;

                int curr = 0;

                for (int i = 0; i < word.length(); i++)
                    if (word.charAt(i) != query.charAt(i))
                        curr++;

                if (curr <= 2) {
                    ans.add(query);
                    break;
                }
            }
        }

        return ans;
    }
}