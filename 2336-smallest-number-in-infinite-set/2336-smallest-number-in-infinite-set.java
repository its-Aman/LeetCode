class SmallestInfiniteSet {
    SortedSet<Integer> set;
    int k;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        k = 1;
    }
    
    public int popSmallest() {
        int ans;
        
        if(!set.isEmpty()) {
            ans = set.first();
            set.remove(ans);
        } else {
            ans = k;
            k++;
        }
        
        return ans;
    }
    
    public void addBack(int num) {
        if(k <= num || set.contains(num)) {
            return;
        }
        
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */