class Solution {
	public int[] diStringMatch(String S) {
		int N = S.length();
		int[] ans = new int[N + 1];
        int lo = 0;
        int hi = N;

		for (int i = 0; i <= N; i++) {
			if (i == N || S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
		}

		return ans;
	}
}