class MyCircularQueue {
    int size;
    int front;
    int rear;
    int used;
    int[] q;

    public MyCircularQueue(int k) {
        q = new int[k];
        size = k;
        front = 0;
        rear = -1;
        used = 0;
    }

    public boolean enQueue(int value) {
        if (used == size)
            return false;

        rear = (rear + 1) % size;
        q[rear] = value;
        ++used;
        return true;
    }

    public boolean deQueue() {
        if (used == 0)
            return false;

        front = (front + 1) % size;
        --used;
        return true;
    }

    public int Front() {
        if (used == 0)
            return -1;

        return q[front];
    }

    public int Rear() {
        if (used == 0)
            return -1;

        return q[rear];
    }

    public boolean isEmpty() {
        return used == 0;
    }

    public boolean isFull() {
        return size == used;
    }
}


/*
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
*/

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