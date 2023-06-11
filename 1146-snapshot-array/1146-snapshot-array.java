class SnapshotArray {
    TreeMap<Integer, Integer>[] snaps;
    int idx = 0;

    public SnapshotArray(int length) {
        snaps = new TreeMap[length];

        while(length-- > 0) {
            snaps[length] = new TreeMap<>();
            snaps[length].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        snaps[index].put(idx, val);
    }
    
    public int snap() {
        return idx++;
    }
    
    public int get(int index, int snap_id) {
        return snaps[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */