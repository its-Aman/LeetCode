public class MinStack {
  
	Stack<Integer> stack;
	int min = Integer.MAX_VALUE;

	public MinStack() {
		this.stack = new Stack<>();

	}

	public void push(int val) {
		this.stack.push(val);
		this.min = Math.min(this.min, val);
	}

	public void pop() {
		if(this.min == this.stack.pop()) {
			if (this.stack.size() > 0) {
				this.min = Collections.min(this.stack);
			} else {
				this.min = Integer.MAX_VALUE;
			}
		}
	}

	public int top() {
		return this.stack.peek();
	}

	public int getMin() {
		return this.min;
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