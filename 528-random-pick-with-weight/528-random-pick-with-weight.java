class Solution {
    int[] prefix;
    int N;
    Random random;

    public Solution(int[] w) {
        N = w.length;
        random = new Random();

        for (int i = 1; i < N; i++)
            w[i] += w[i - 1];

        prefix = w;
    }
    
    public int pickIndex() {
        int num = random.nextInt(prefix[N - 1]) + 1;
        int l = 0, r = N - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (prefix[m] == num)
                return m;
            else if (num > prefix[m])
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */