class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int N = queries.length;
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            if(val == 0) {
                map.putIfAbsent(val, new int[]{i, i});
                continue;
            }
            
            for (int j = i, num = 0; j < i + 31 && j < s.length(); j++) {
                val = s.charAt(j) - '0';
                num = num * 2 + val;
                map.putIfAbsent(num, new int[]{i, j});
            }
        }

        int[][] ans = new int[N][2];
        for (int i = 0; i < N; i++) {
            int num = queries[i][0] ^ queries[i][1];
            ans[i] = map.getOrDefault(num, new int[]{-1, -1});
        }

        return ans;
    }
}