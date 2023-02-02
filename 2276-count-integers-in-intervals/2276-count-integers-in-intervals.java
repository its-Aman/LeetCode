class CountIntervals {

    private CountIntervals left, right;
    private int lb, ub, count;

    public CountIntervals() {
        lb = 1;
        ub = 1_000_000_000;
        count = 0;
    }
    
    public CountIntervals(int lb, int ub, int val) {
        this.lb = lb;
        this.ub = ub;
        this.count = val;
    }
    
    public void add(int l, int r) {
        // interval has already been fully covered before
        // no need to cover again
        if (count == ub - lb + 1) {
            return;
        }
        
        // interval has already been covered by [l, r]
        // no need to discover further
        if (l <= lb && ub <= r) {
            count = ub - lb + 1;
            return;
        }

        int mid = lb + (ub - lb) / 2;
        /* push down */
        if (left == null) left = new CountIntervals(lb, mid, 0);
        if (right == null) right = new CountIntervals(mid + 1, ub, 0);

        if (l <= mid) left.add(l, r);
        if (r > mid) right.add(l, r);

        /* push up */
        count = left.count + right.count;
    }
    
    public int count() {
        return count;
    }
}

class CountIntervals2 {
    TreeMap<Integer, Integer> map;
    int cnt;
    
    public CountIntervals2() {
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