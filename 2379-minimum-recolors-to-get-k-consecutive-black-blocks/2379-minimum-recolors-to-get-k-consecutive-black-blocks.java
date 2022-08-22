class Solution {
	public int minimumRecolors(String blocks, int K) {
		int white = 0, ans = 0;

		for (int i = 0; i < K; i++) {
			if (blocks.charAt(i) == 'W')
				white += 1;
		}

		ans = white;

		for (int i = K; i < blocks.length(); i++) {
			if (blocks.charAt(i - K) == 'W')
				white -= 1;

			if (blocks.charAt(i) == 'W')
				white += 1;

			ans = Math.min(ans, white);
		}

		return ans;
	}
}