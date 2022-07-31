// https://codeforces.com/blog/entry/57292

class NumArray {

  private int N;
	private int[] BIT;
	private int[] originalArr;

  public NumArray(int[] nums) {
		this.N = nums.length;
		this.BIT = new int[this.N + 1];
		this.originalArr = nums;

		this.buildTree();
  }

	public void update(int idx, int value) {
		int delta = value - this.originalArr[idx];
		this.originalArr[idx] = value;
		int x = idx + 1;

		while (x <= this.N) {
			this.BIT[x] += delta;
			x += x & -x;
		}
	}


  public int sumRange(int left, int right) {
    if(left > 0) {
      return this.query(right) - this.query(left - 1);
    } else {
      return this.query(right);
    }
  }
  
  private int query(int idx) {
		int ans = 0;
		int x = idx + 1;

		while (x > 0) {
			ans += this.BIT[x];
			x -= x & -x;
		}

		return ans;
	}
  
  private void buildTree() {
    
		for (int i = 0; i < this.N; i++) {
			int x = i + 1;

			while (x <= this.N) {
				this.BIT[x] += this.originalArr[i];
				x += x & -x;
			}
		}
	}

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */