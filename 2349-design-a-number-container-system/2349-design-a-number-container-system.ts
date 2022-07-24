class NumberContainers {
    private num: Map<number, number>;
    private numMap: Map<number, typeof MinPriorityQueue>;

    constructor() {
        this.num = new Map<number, number>();
        this.numMap = new Map<number, typeof MinPriorityQueue>();
    }

    change(I: number, N: number): void {
        this.num.set(I, N);

        if (!this.numMap.has(N))
            this.numMap.set(N, new MinPriorityQueue());

        this.numMap.get(N).enqueue(I, 1 + I);
    }

    find(N: number): number {
        while (
            this.numMap.has(N) &&
            this.numMap.get(N).size() > 0 &&
            this.num.get(this.numMap.get(N).front().element) != N
        )
            this.numMap.get(N).dequeue();


        if (this.numMap.has(N) && this.numMap.get(N).size() > 0)
            return this.numMap.get(N).front().element;

        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = new NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */