class MyQueue {
    private st_push = new Array<number>();
    private st_pop = new Array<number>();

    constructor() {}

    push(x: number): void {
      this.st_push.push(x);
    }

    pop(): number {
      if(!this.st_pop.length)
        while(this.st_push.length)
          this.st_pop.push(this.st_push.pop());
      
      return this.st_pop.pop();
    }

    peek(): number {
      return this.st_pop[this.st_pop.length - 1] ?? this.st_push[0];
    }

    empty(): boolean {
      return !this.st_push.length && !this.st_pop.length;
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