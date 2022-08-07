class Solution {
	public int countVowelPermutation(int N) {
		long a = 1, e = 1, i = 1, o = 1, u = 1;
		long a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0;
		int MOD = (int) 1e9 + 7;

		while (N > 1) {
			a2 = (e + i + u) % MOD;
			e2 = (a + i) % MOD;
			i2 = (e + o) % MOD;
			o2 = (i) % MOD;
			u2 = (i + o) % MOD;

			a = a2;
			e = e2;
			i = i2;
			o = o2;
			u = u2;

			N -= 1;
		}

		return (int) ((a + e + i + o + u) % MOD);
	}
}