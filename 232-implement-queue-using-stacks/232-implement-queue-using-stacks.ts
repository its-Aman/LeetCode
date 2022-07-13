class MyQueue {
    private stack = new Array<number>();

    constructor() {

    }

    push(x: number): void {
      this.stack.push(x);
    }

    pop(): number {
      let temp = new Array<number>();
      
      while(this.stack.length)
        temp.push(this.stack.pop());
      
      const item = temp.pop();
      
      while(temp.length)
        this.stack.push(temp.pop());
      
      return item;
    }

    peek(): number {
      return this.stack[0];
    }

    empty(): boolean {
      return this.stack.length == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */