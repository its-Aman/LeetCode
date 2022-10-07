class MyCalendarThree3 {
    private Map<Integer, Integer> vals, lazy;

    public MyCalendarThree3() {
        vals = new HashMap<>();
        lazy = new HashMap<>();
    }
    
    public int book(int start, int end) {
        update(start, end - 1, 0, 1000000000, 1);
        return vals.getOrDefault(1, 0);
    }
    
    private void update(int start, int end, int left, int right, int idx) {
        if(start > right || end < left)
            return;

        if(start <= left && end >= right) {
            vals.put(idx, vals.getOrDefault(idx, 0) + 1);            
            lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);            
        } else {
            int mid = left + (right - left) / 2;
            
            update(start, end, left, mid, idx * 2);
            update(start, end, mid + 1, right, idx * 2 + 1);

            int val = Math.max(vals.getOrDefault(idx * 2, 0), vals.getOrDefault(idx * 2 + 1, 0));
            
            vals.put(idx, lazy.getOrDefault(idx, 0) + val);
        }
    }
}

// sweep line
class MyCalendarThree {
    Map<Integer, Integer> times;

    public MyCalendarThree() {
        times = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        times.put(start, times.getOrDefault(start, 0) + 1);
        times.put(end, times.getOrDefault(end, 0) - 1);
        int ans = 0, curr = 0;
        
        for(int d: times.values())
            ans = Math.max(ans, curr += d);

        return ans;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */