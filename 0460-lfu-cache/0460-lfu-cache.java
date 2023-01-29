class Node {
    int key, val, cnt;
    Node prev, next;

    public Node(int k, int v) {
        key = k;
        val = v;
        cnt = 1;
    }
}

class DoubleyLinkedList {
    int size;
    Node head, tail;

    DoubleyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    void add(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        size++;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
        size--;
    }

    Node removeLast() {
        if (size == 0) {
            return null;
        }

        Node node = tail.prev;
        remove(node);
        return node;
    }
}

class LFUCache {
    int cap, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DoubleyLinkedList> freqMap;

    public LFUCache(int C) {
        cap = C;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0) {
            return;
        }

        Node node;

        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            node = new Node(key, value);
            nodeMap.put(key, node);

            if (size == cap) {
                DoubleyLinkedList lastList = freqMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DoubleyLinkedList newList = freqMap.getOrDefault(node.cnt, new DoubleyLinkedList());
            newList.add(node);
            freqMap.put(node.cnt, newList);
        }
    }

    private void update(Node node) {
        DoubleyLinkedList oldList = freqMap.get(node.cnt);
        oldList.remove(node);

        if (node.cnt == min && oldList.size == 0) {
            min++;
        }

        node.cnt++;

        DoubleyLinkedList newList = freqMap.getOrDefault(node.cnt, new DoubleyLinkedList());
        newList.add(node);
        freqMap.put(node.cnt, newList);
    }
}

/**
* Your LFUCache object will be instantiated and called as such:
* LFUCache obj = new LFUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/