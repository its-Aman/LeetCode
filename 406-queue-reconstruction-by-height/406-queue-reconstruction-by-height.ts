// https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89342/O(nlogn)-Binary-Index-Tree-C%2B%2B-solution
function reconstructQueue(people: number[][]): number[][] {
  const N = people.length,
        res = new Array<Array<number>>(N),
        bit = new BIT(N);
  
  people.sort((p1, p2) => p1[0] == p2[0] ? -p1[1] + p2[1] /* <- this is ascending */ : p1[0] - p2[0] /* <-- this is decending */);
  
  for(let [h, k] of people) {
    let lo = 0,
        hi = N;
    while(lo < hi) {
      const mid = lo + ((hi - lo) >>> 1),
            used = bit.query(mid); // get # of used slot in [0, mid)
      if(mid - used < k)
        lo = mid + 1; // we need more unused slot
      else
        hi = mid;
    }
    res[lo] = [h, k];
    bit.update(lo);
  }
  
  return res;
};

// https://www.youtube.com/watch?v=CWDQJGaN1gY
class BIT {
  private bit: Array<number>;
  private N: number;

  constructor(size: number) {
    this.N = size + 1;
    this.bit = new Array(this.N).fill(0);
  }

  public update(pos: number): void {
    pos += 1; // pos is 0 based
    while(pos < this.N) {
      this.bit[pos] += 1;
      pos += pos & (-pos);  // this will jump to the next available index of the tree
    }
  }
  
  public query(pos: number): number {
    // this will get the # of used slot before pos including this pos
    let cnt = 0;
    pos += 1; // pos is 0 based
    while(pos > 0) {
      cnt += this.bit[pos];
      pos -= pos & (-pos); // this will jump to the parent
    }
    return cnt;    
  }
}