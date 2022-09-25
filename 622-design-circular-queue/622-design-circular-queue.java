class MyCircularQueue {
    int size;
    Deque<Integer> q;

    public MyCircularQueue(int k) {
        size = k;
        q = new ArrayDeque<>(k);
    }

    public boolean enQueue(int value) {
        if (q.size() == size)
            return false;

        return q.offerLast(value);
    }

    public boolean deQueue() {
        if (q.isEmpty())
            return false;

        q.pollFirst();
        return true;
    }

    public int Front() {
        if (q.isEmpty())
            return -1;

        return q.peekFirst();
    }

    public int Rear() {
        if (q.isEmpty())
            return -1;
        
        return q.peekLast();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public boolean isFull() {
        return size == q.size();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */