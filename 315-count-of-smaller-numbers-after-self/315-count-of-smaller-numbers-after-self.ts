
class SegmentTree {

    /**
     * Segment tree helps to find the answers of queries for an array of following types
     * Q1: What is the min element in range left, right (inclusive)
     * Q2: What is the max element in range left, right (inclusive)
     * Q3: What is the sum of elements in range left, right (inclusive)
     * and so on. 
     * Basically Segment tree help us to keep track of the element that are part of segments 
     * and help us find the answers for a particular range. 
     * 
     * All the operations are O(logN), where N is the length of the array. 
     * At most the tree will be having 4*N elements at a given time.
     * 
     * build() will take O(logN) recursive calls to build the tree.
     * find() / sum() will also take O(logN) recursive calls to find the range query.
     * update() will also take O(logN) recursive calls to update the tree.
     */

    private tree: number[];
    private N = 0;

    constructor(N: number) {
        this.N = N;
        this.tree = new Array(4 * this.N).fill(0);
    }

    public build(arr: number[], v: number, tl: number, tr: number): void {
        if (tl == tr) {
            this.tree[v] = arr[tl];
        } else {
            const tm = tl + Math.floor((tr - tl) / 2);
            this.build(arr, 2 * v, tl, tm);
            this.build(arr, 1 + (2 * v), 1 + tm, tr);
            this.tree[v] = this.tree[2 * v] + this.tree[1 + (2 * v)];
        }
    }

    public query(r: number, l: number = 0, v: number = 1, tl: number = 0, tr: number = this.N - 1): number {
        if (l > r) {
            return 0;
        }

        if (tl == l && tr == r) {
            return this.tree[v];
        }

        const tm = tl + Math.floor((tr - tl) / 2);
        return (
            this.query(Math.min(r, tm), l, 2 * v, tl, tm) +
            this.query(r, Math.max(l, 1 + tm), 1 + (2 * v), 1 + tm, tr)
        );
    }

    public update(pos: number, v: number = 1, tl: number = 0, tr: number = this.N - 1): void {
        if (tl == tr) {
            this.tree[v] += 1;
        } else {
            const tm = tl + Math.floor((tr - tl) / 2);
            if (pos <= tm) {
                this.update(pos, 2 * v, tl, tm);
            } else {
                this.update(pos, 1 + (2 * v), 1 + tm, tr);
            }
            this.tree[v] = this.tree[2 * v] + this.tree[1 + (2 * v)];
        }
    }
}

function countSmaller(nums: number[]): number[] {
  const MAX = 1 + 1e4,
        N = nums.length,
        sgTree = new SegmentTree(2 * MAX),
        ans = new Array(N).fill(0);
  
  for(let i = N - 1; i >= 0; i--) {
    sgTree.update(nums[i] + MAX);
    ans[i] = sgTree.query(nums[i] + MAX - 1);
  }
  
  return ans;
  
};