import "container/list"

type Node struct {
	key int
	val int
}

type LRUCache struct {
	capacity int
	data     map[int]*list.Element
	hits     *list.List
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		capacity: capacity,
		data:     make(map[int]*list.Element),
		hits:     list.New(),
	}
}

func (this *LRUCache) Get(key int) int {
	if item, ok := this.data[key]; ok {
		this.hits.MoveToFront(item)
		return item.Value.(Node).val
	}
	return -1
}

func (this *LRUCache) Put(key, val int) {
	if item, ok := this.data[key]; ok {
		item.Value = Node{key: key, val: val}
		this.hits.MoveToFront(item)
		return
	}

	if this.capacity == this.hits.Len() {
		last := this.hits.Back()
		delete(this.data, last.Value.(Node).key)
		this.hits.Remove(last)
	}

	this.data[key] = this.hits.PushFront(Node{key: key, val: val})
}

// type DLNode struct {
// 	prev *DLNode
// 	next *DLNode
// 	key  int
// 	val  int
// }

// type LRUCache struct {
// 	capacity int
// 	size     int
// 	lru      map[int]*DLNode
// 	head     DLNode
// 	tail     DLNode
// }

// func (this *LRUCache) moveToHead(key int) {
// 	this.remove(key)
// 	this.addToHead(key)
// }

// func (this *LRUCache) remove(key int) {
// 	this.lru[key].prev.next = this.lru[key].next
// 	this.lru[key].next.prev = this.lru[key].prev
// }

// func (this *LRUCache) addToHead(key int) {
// 	this.lru[key].prev = &this.head
// 	this.lru[key].next = this.head.next

// 	this.head.next.prev = this.lru[key]
// 	this.head.next = this.lru[key]
// }

// func (this *LRUCache) popTail() int {
// 	prev := this.tail.prev
// 	this.remove(prev.key)
// 	return prev.key
// }

// func Constructor(capacity int) LRUCache {
// 	head, tail := DLNode{}, DLNode{}

// 	head.next = &tail
// 	tail.prev = &head

// 	lruCache := LRUCache{
// 		size:     0,
// 		capacity: capacity,
// 		lru:      make(map[int]*DLNode),
// 		head:     head,
// 		tail:     tail,
// 	}

// 	fmt.Printf("%+v\n", lruCache.lru)

// 	return lruCache
// }

// func (this *LRUCache) Get(key int) int {
// 	fmt.Printf("Get: Key = %+v\n", key)
// 	if item := this.lru[key]; item == nil {
// 		return -1
// 	}
// 	this.moveToHead(key)
// 	return this.lru[key].val
// }

// func (this *LRUCache) Put(key int, value int) {
// 	fmt.Printf("Put: Key = %+v, Val = %+v\n", key, value)
// 	if item := this.lru[key]; item != nil {
// 		this.lru[key].val = value
// 		this.moveToHead(key)
// 		return
// 	}
// 	this.size++
// 	this.lru[key] = &DLNode{key: key, val: value}
// 	this.addToHead(key)

// 	if this.size > this.capacity {
// 		this.lru[this.popTail()] = nil
// 	}
// }
