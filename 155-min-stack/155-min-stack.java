public class MinStack {
  
	Stack<Integer> stack;
	Queue<Integer> q;

	public MinStack() {
		stack = new Stack<>();
		q = new PriorityQueue<>();
	}

	public void push(int val) {
		stack.push(val);
		q.offer(val);
	}

	public void pop() {
		int val = stack.pop();

		q.remove(val);
  }

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return q.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */