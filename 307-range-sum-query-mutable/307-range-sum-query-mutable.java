class NumArray {
  private int N;
  private int[] segmentTree;
  
  public NumArray(int[] nums) {
    this.N = nums.length;
    this.segmentTree = new int[4 * this.N];
    this.build(nums, 1, 0, this.N - 1);
  }
  
  private void build(int[] arr, int vtx, int left, int right) {
    if(left == right) {
      this.segmentTree[vtx] = arr[left];
    } else {
      int mid = left + (right - left) / 2;
      
      this.build(arr, 2 * vtx, left, mid);
      this.build(arr, 2 * vtx + 1, mid + 1, right);
      
      this.segmentTree[vtx] = this.segmentTree[2*vtx] + this.segmentTree[2*vtx + 1];
    }
  }
  
  public void update(int index, int val) {
    this.update(1, 0, this.N - 1, index, val);
  }
  
  private void update(int vtx, int left, int right, int idx, int value) {
    if(left == right) {
      this.segmentTree[vtx] = value;
    } else {
      int mid = left + (right - left) / 2;
      
      if(idx <= mid) {
        this.update(2 * vtx, left, mid, idx, value);
      } else {
        this.update(2 * vtx + 1, mid + 1, right, idx, value);
      }
      
      this.segmentTree[vtx] = this.segmentTree[2*vtx] + this.segmentTree[2*vtx + 1];
    }
  }

  public int sumRange(int left, int right) {
    return this.sumRange(1, 0, this.N - 1, left, right);
  }
  
  public int sumRange(int vtx, int left, int right, int qLeft, int qRight) {
    if(qLeft > qRight) {
      return 0;
    }
    
    if(left == qLeft && right == qRight){
      return this.segmentTree[vtx];
    } else {
      int mid = left + (right - left) / 2;
      
      return (
        this.sumRange(2 * vtx, left, mid, qLeft, Math.min(qRight, mid)) + 
        this.sumRange(2 * vtx + 1, mid + 1, right, Math.max(qLeft, mid + 1), qRight)
      );
    }
  }
  
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */