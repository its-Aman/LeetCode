class Solution {
    
	public int[] movesToStamp(String stamp, String target) {
		int stars = 0, lenT = target.length(), lenS = stamp.length();
		char[] S = stamp.toCharArray();
		char[] T = target.toCharArray();
		boolean[] seen = new boolean[lenT];
		List<Integer> list = new ArrayList<>();

		while (stars < lenT) {
			boolean isReplaceable = false;

			for (int i = 0; i <= lenT - lenS; i++) {

				if (!seen[i] && this.canReplace(T, i, S)) {
					stars += this.doReplace(T, i, lenS);
					isReplaceable = true;
					seen[i] = true;
					list.add(i);

					if (stars == lenT)
						break;

				}

			}

			if (!isReplaceable)
				return new int[0];

		}

		int[] ans = new int[list.size()];

		for (int i = 0; i < list.size(); i++)
			ans[i] = list.get(list.size() - 1 - i);

		return ans;
	}

	private boolean canReplace(char[] T, int i, char[] S) {

		for (int j = 0; j < S.length; j++) {
			if (T[j + i] != '*' && T[j + i] != S[j])
				return false;
		}

		return true;
	}

	private int doReplace(char[] T, int i, int N) {
		int stars = 0;

		for (int j = 0; j < N; j++) {
			if (T[j + i] != '*') {
				T[j + i] = '*';
				stars += 1;
			}
		}

		return stars;
	}

}