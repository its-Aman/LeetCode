class Solution {
	public int[] diStringMatch(String S) {
		int N = S.length();
		int j = 0;
		int[] ans = new int[N + 1];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i <= N; i++) {
			stack.push(i);

			if (i == N || S.charAt(i) == 'I') {

				while (!stack.isEmpty())
					ans[j++] = stack.pop();

			}
		}

		return ans;
	}
}