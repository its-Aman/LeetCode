class LRUCache {

	class DLNode {
		int key;
		int value;
		DLNode pre;
		DLNode post;

		DLNode() {

		}

		DLNode(int K, int V) {
			this.key = K;
			this.value = V;
		}
	}

	private int capacity;

	private Map<Integer, DLNode> container = new HashMap<>();
	private DLNode head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;

		this.head = new DLNode();
		this.tail = new DLNode();

		this.head.pre = null;
		this.head.post = this.tail;

		this.tail.pre = this.head;
		this.tail.post = null;
	}

	public int get(int key) {
		DLNode node = this.container.get(key);

		if (node == null)
			return -1;

		this.moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		DLNode node = this.container.get(key);

		if (node == null) {
			DLNode newNode = new DLNode(key, value);
			this.add(newNode);
			this.container.put(key, newNode);

			if (this.container.size() > this.capacity) 
				this.container.remove(this.popTail().key);
            
		} else {
			node.value = value;
			this.moveToHead(node);
		}
	}

	private void add(DLNode node) {
		node.pre = this.head;
		node.post = this.head.post;

		this.head.post.pre = node;
		this.head.post = node;
	}

	private void remove(DLNode node) {
		DLNode pre = node.pre;
		DLNode post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	private void moveToHead(DLNode node) {
		this.remove(node);
		this.add(node);
	}

	private DLNode popTail() {
		DLNode tail = this.tail.pre;
		this.remove(tail);
		return tail;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */