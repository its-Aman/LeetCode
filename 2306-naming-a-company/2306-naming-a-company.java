class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] map = new Set[26];
        int[][] cnt = new int[26][26];
        long ans = 0;

        for (int i = 0; i < 26; i++) {
            map[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            map[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        for (int i = 0; i < 26; i++) {
            for (String s : map[i]) {
                for (int j = i + 1; j < 26; j++) {
                    if (map[j].contains(s)) {
                        cnt[i][j] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                ans += 2L * (map[i].size() - cnt[i][j]) * (map[j].size() - cnt[i][j]);
            }
        }

        return ans;
    }

    public long distinctNames2(String[] ideas) {
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