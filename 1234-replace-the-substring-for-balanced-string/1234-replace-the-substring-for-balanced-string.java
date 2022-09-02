class Solution {
    public int balancedString(String S) {
        int N = S.length(), ans = N + 1;
        var map = new HashMap<Character, Integer>();
        map.put('Q', 0);
        map.put('W', 1);
        map.put('E', 2);
        map.put('R', 3);
        int[] inWindowCount = new int[4];
        int[] outWindowCount = new int[4];

        for (int i = 0; i < N; i++)
            outWindowCount[map.get(S.charAt(i))]++;

        if(checkValid(outWindowCount, N/4))
            return 0;

        for (int left = 0, right = 0; right < N; right++) {
            int r = map.get(S.charAt(right));
            inWindowCount[r]++;
            outWindowCount[r]--;

            while (checkValid(outWindowCount, N / 4)) {
                ans = Math.min(ans, right - left + 1);
                int l = map.get(S.charAt(left++));
                inWindowCount[l] -= 1;
                outWindowCount[l] += 1;
            }

        }

        return ans > N ? 0 : ans;
    }

    private boolean checkValid(int[] count, int K) {
        for (int c : count)
            if (c > K)
                return false;

        return true;
    }

}