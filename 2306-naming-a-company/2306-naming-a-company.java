class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] map = new Set[26];
        long ans = 0;

        for (String idea : ideas) {
            int idx = idea.charAt(0) - 'a';

            if (map[idx] == null) {
                map[idx] = new HashSet<>();
            }

            map[idx].add(idea.substring(1));
        }

        for (int i = 0; i < 25; i++) {
            if (map[i] == null) {
                continue;
            }

            for (int j = i + 1; j < 26; j++) {
                if (map[j] == null) {
                    continue;
                }

                Set<String> intersection = new HashSet<>(map[i]);
                intersection.retainAll(map[j]);
                long numOfMutual = intersection.size();

                ans += 2 * (map[i].size() - numOfMutual) * (map[j].size() - numOfMutual);
            }
        }

        return ans;
    }
}