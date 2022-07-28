class Solution {
	public int minAddToMakeValid(String S) {
		int ans = 0;
		int openCnt = 0;

		for (char c : S.toCharArray()) {
			if (c == '(') {
				openCnt += 1;
			} else {
				if (openCnt == 0) {
					ans += 1;
				} else {
					openCnt -= 1;
				}
			}
		}

		return ans + openCnt;
	}

}