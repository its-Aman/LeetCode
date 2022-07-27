public class MinStack {

  // MinNode class
  
  private class MinNode  {
    int val;
    int min;
    MinNode next;

    public MinNode(int val, int min, MinNode next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }
  
	MinNode head;

	public MinStack() {	}

	public void push(int val) {
		if (this.head == null) {
			this.head = new MinNode(val, val, null);
		} else {
			this.head = new MinNode(val, Math.min(val, head.min), head);
		}
	}

	public void pop() {
		this.head = this.head.next;
	}

	public int top() {
		return this.head.val;
	}

	public int getMin() {
		return this.head.min;
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