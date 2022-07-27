class Solution {

	Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	Stack<Integer> stack = new Stack<Integer>();
	boolean[] seen;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		seen = new boolean[numCourses];

		this.graph.clear();
		this.stack.clear();

		this.buildGraph(numCourses, prerequisites);

		for (int i = 0; i < numCourses; i++) {
			if (this.hasCycle(i)) {
				return false;
			}
		}

		return true;
	}

	private void buildGraph(int numCourses, int[][] prerequisites) {
		for (int i = 0; i < numCourses; i++) {
			this.graph.put(i, new LinkedList<Integer>());
		}

		for (int[] item : prerequisites) {
			this.graph.get(item[0]).add(item[1]);
		}
	}

	private boolean hasCycle(int v) {

		if (this.seen[v]) {
			return this.stack.contains(v);
		}

		this.seen[v] = true;
		this.stack.push(v);

		for (int item : this.graph.get(v)) {
			if (this.hasCycle(item)) {
				return true;
			}
		}

		this.stack.pop();
		return false;
	}
}