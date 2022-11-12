class MedianFinder {
    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;
    private boolean isEven;

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>();
        isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            maxPQ.offer(num);
            minPQ.offer(-maxPQ.poll());
        } else {
            minPQ.offer(-num);
            maxPQ.offer(-minPQ.poll());
        }

        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            return (maxPQ.peek() - minPQ.peek()) / 2.0;
        } else {
            return -minPQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */