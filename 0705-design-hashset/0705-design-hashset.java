class MyHashSet {
    int[] set;

    public MyHashSet() {
        set = new int[31251];
    }
    
    public void add(int key) {
        set[getIdx(key)] |= getMask(key);
    }
    
    public void remove(int key) {
        set[getIdx(key)] &= (~getMask(key));
    }
    
    public boolean contains(int key) {
        return (set[getIdx(key)] & getMask(key)) != 0;
    }
    
    private int getIdx(int key) {
        return key/32;
    }

    private int getMask(int key) {
        return 1<<(key%32);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */