class CountIntervals {
    TreeMap<Integer, Integer> map;
    int cnt;
    
    public CountIntervals() {
        map = new TreeMap<>();
        cnt = 0;
    }
    
    public void add(int left, int right) {
        int start = left, end = right;
        int diff = end - start + 1;
        
        var floor = map.floorEntry(left);
        
        if(floor != null) {
            int key = floor.getKey(),
                val = floor.getValue();
            
            if(val >= end) {
                // floor covers the curr interval entirely.
                // no need to calculate new interval.
                return;
            }
            
            if(val >= start) {
                diff -= val - start + 1;
                map.remove(key);
                start = key;
            }
        }
        
        var ceil = map.ceilingEntry(left);
        
        while(ceil != null && ceil.getKey() <= end) {
            diff -= Math.min(end, ceil.getValue()) - ceil.getKey() + 1;
            map.remove(ceil.getKey());
            end = Math.max(end, ceil.getValue());
            ceil = map.ceilingEntry(left);
        }
        
        cnt += diff;
        map.put(start, end);
    }
    
    public int count() {
        return cnt;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */