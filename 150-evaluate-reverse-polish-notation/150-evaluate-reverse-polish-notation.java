interface Operationable {
	int op(int n1, int n2);
}

class Solution {
	public int evalRPN(String[] tokens) {
		HashMap<String, Operationable> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		map.put("+", (b, a) -> a + b);
		map.put("-", (b, a) -> a - b);
		map.put("/", (b, a) -> a / b);
		map.put("*", (b, a) -> a * b);

		for (String token : tokens) {
			if ("+-*/".contains(token)) {
				int ans = map.get(token).op(stack.pop(), stack.pop());
				stack.push(ans);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}
}