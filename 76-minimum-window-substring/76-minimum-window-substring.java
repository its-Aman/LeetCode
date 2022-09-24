class Solution {
    public String minWindow(String s, String t) {
        int M = s.length(), N = t.length();
        int[] mapT = new int[1 << 6],
                mapS = new int[1 << 6];
        String ans = "";
        int count = 0;

        for (char c : t.toCharArray()) {
            if (mapT[c - 'A'] == 0)
                ++count;
            ++mapT[c - 'A'];
        }

        int l = 0, r = 0, formed = 0;

        while (r < M) {
            int currIdx = s.charAt(r) - 'A';
            ++mapS[currIdx];

            if (mapT[currIdx] == mapS[currIdx])
                ++formed;

            while (l <= r && formed == count) {
                int len = ans.length();
                currIdx = s.charAt(l) - 'A';

                if (len == 0 || (r - l + 1) < len)
                    ans = s.substring(l, r + 1);

                --mapS[currIdx];

                if (mapS[currIdx] < mapT[currIdx])
                    --formed;

                l++;
            }
            r++;
        }

        return ans;
    }
}