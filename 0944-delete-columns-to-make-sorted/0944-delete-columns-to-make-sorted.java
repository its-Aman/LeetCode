class Solution {
    public int minDeletionSize(String[] strs) {
        int R = strs.length;
        int C = strs[0].length();
        int ans = 0;

        for (int c = 0; c < C; c++) {
            for (int r = 1; r < R; r++) {
                if(strs[r - 1].charAt(c) > strs[r].charAt(c)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
    
    public int minDeletionSize_2(String[] strs) {
        int N = strs.length;
        int L = strs[0].length();
        int ans = 0;

        for (int i = 0; i < L; i++) {
            char[] c = new char[N];
            for (int j = 0; j < N; j++) {
                c[j] = strs[j].charAt(i);
            }
            
            String s = new String(c);
            Arrays.sort(c);

            if (!s.equals(new String(c))) {
                ans += 1;
            }
        }

        return ans;
    }    
}