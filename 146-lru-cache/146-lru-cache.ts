class LRUCache extends Map<number, any>{
    private cap: number;
  
    constructor(capacity: number) {
      super();
      this.cap = capacity;
    }

    get(key: number): number {
      if(!super.has(key))
        return -1;
      
      const value = super.get(key);
      super.delete(key);
      super.set(key, value);
      return value;
    }

    put(key: number, value: number): void {
      if(super.has(key))
        super.delete(key);

      super.set(key, value);

      if(super.size > this.cap)
        super.delete(super.keys().next().value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */