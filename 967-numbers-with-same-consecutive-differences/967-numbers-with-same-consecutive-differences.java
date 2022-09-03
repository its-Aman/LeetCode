class Solution {
    List<Integer> ans = new ArrayList<>();

    public int[] numsSameConsecDiff(int N, int K) {

        for (int i = 1; i < 10; i++)
            this.dfs(N, K, i, 0, i);

        return this.toIntArray();
    }
    
    private void dfs(int N, int K, int curr, int idx, int prev) {

        if (idx == N - 1) {
            this.ans.add(curr);
            return;
        }

        int next = prev + K;
        if (next < 10)
            this.dfs(N, K, (curr * 10) + next, idx + 1, next);

        next = prev - K;
        if (K != 0 && next >= 0)
            this.dfs(N, K, (curr * 10) + next, idx + 1, next);
    }


    private int[] toIntArray() {
        var res = new int[this.ans.size()];
        
        for(int i = 0; i < this.ans.size(); i++)
            res[i] = this.ans.get(i);
        return res;
    }

}