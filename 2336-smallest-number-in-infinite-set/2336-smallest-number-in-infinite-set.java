class SmallestInfiniteSet {
    boolean[] set = new boolean[1001];
    int idx = 1;

    public SmallestInfiniteSet() {
        for(int i=0; i<set.length; i++) {
            set[i] = true;
        }
    }
    
    public int popSmallest() {
        for(int i=1; i<set.length; i++) {
            if(set[i] == true) {
                set[i] = false;
                return i;
            }
        }
        
        return -1;
    }
    
    public void addBack(int num) {
        set[num] = true;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */