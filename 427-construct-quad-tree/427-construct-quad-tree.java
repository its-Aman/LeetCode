/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {

	public Node construct(int[][] grid) {
		return this.construct(grid, grid.length, 0, 0);
	}

	public Node construct(int[][] grid, int N, int x, int y) {
		Node curr = new Node();

		if (N <= 1)
			return new Node(grid[x][y] == 1, true);

		int one = 0;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				one += 1 & grid[x + i][y + j];

		int total = N * N;

		if (one == total || one == 0) {
			curr.isLeaf = true;
			curr.val = one == total;
		} else {
			N /= 2;
			curr.isLeaf = false;
			curr.topLeft = this.construct(grid, N, x, y);
			curr.topRight = this.construct(grid, N, x, y + N);
			curr.bottomLeft = this.construct(grid, N, x + N, y);
			curr.bottomRight = this.construct(grid, N, x + N, y + N);
		}

		return curr;
	}
}