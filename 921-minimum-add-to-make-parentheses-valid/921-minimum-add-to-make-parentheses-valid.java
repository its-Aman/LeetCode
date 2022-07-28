class Solution {
	public int minAddToMakeValid(String S) {
		int ans = 0;
		Stack<String> stack = new Stack<>();

		for (char c : S.toCharArray()) {
			if (c == '(') {
				ans += 1;
				stack.push("" + c);
			} else {
				if (stack.size() > 0) {
					ans -= 1;
					stack.pop();
				} else {
					ans += 1;
				}
			}
		}

		return Math.abs(ans);
	}
}