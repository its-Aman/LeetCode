class Solution {
    
    public String shiftingLetters(String S, int[][] shifts) {
        return this.shiftingLetters_fenwickTree(S, shifts);
    }
    
	int N;
	int[] bTree;

	public String shiftingLetters_fenwickTree(String S, int[][] shifts) {
		this.N = S.length();
		this.bTree = new int[this.N + 1];
		char[] c = S.toCharArray();

		for (int[] s : shifts) {
			int d = s[2] == 1 ? 1 : -1;
			this.add(s[0], d);
			this.add(s[1] + 1, -d);
		}

		for (int i = 0; i < this.N; i++) {
			int increaseBy = (c[i] - 'a') + this.prefixSum(i) % 26;
			int onlyPositiveMod = (increaseBy + 26) % 26;
			c[i] = (char) ('a' + onlyPositiveMod);
		}
		
		return new String(c);
	}

	public void add(int idx, int val) {
		for (int i = idx + 1; i <= N; i += i & (-i))
			this.bTree[i] += val;
	}

	public int prefixSum(int idx) {
		int sum = 0;

		for (int i = idx + 1; i > 0; i -= i & (-i))
			sum += this.bTree[i];

		return sum;
	}

	public String shiftingLetters_lineSweep(String S, int[][] shifts) {
		char[] cs = S.toCharArray();
		int[] line = new int[S.length() + 1];

		for (int[] s : shifts) {
			line[s[0]] += s[2] == 1 ? 1 : -1;
			line[s[1] + 1] += s[2] == 1 ? -1 : 1;
		}

		for (int i = 0, prefix = 0; i < S.length(); i++) {
			prefix = (prefix + line[i]) % 26;
			int increaseBy = (cs[i] - 'a' + prefix) % 26;
			int onlyPositiveMod = (increaseBy + 26) % 26;
			cs[i] = (char) ('a' + onlyPositiveMod);
		}

		return new String(cs);
	}

	public String shiftingLetters_bruteForce(String S, int[][] shifts) {
		char[] cs = S.toCharArray();

		for (int[] shift : shifts) {
			int s = shift[0];
			int e = shift[1];
			int d = shift[2];

			while (s <= e) {

				if (d == 1) { // forward
					if (cs[s] == 'z')
						cs[s] = 'a';
					else
						cs[s] += 1;
				} else { // backward
					if (cs[s] == 'a')
						cs[s] = 'z';
					else
						cs[s] -= 1;
				}

				s += 1;
			}
		}

		return new String(cs);
	}
}