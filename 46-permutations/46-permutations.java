class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		boolean[] used = new boolean[nums.length];

		this.backtrack(nums, ans, new Stack<>(), 0, used);

		return ans;

	}

	private void backtrack(int[] nums, List<List<Integer>> ans, Stack<Integer> curr, int idx, boolean[] used) {

		if (curr.size() == nums.length) {
			ans.add(curr);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[(i + idx) % nums.length])
				continue;

			used[(i + idx) % nums.length] = true;
			curr.push(nums[(i + idx) % nums.length]);
			this.backtrack(nums, ans, (Stack<Integer>) curr.clone(), (1 + i + idx) % nums.length, used);
			curr.pop();
			used[(i + idx) % nums.length] = false;
		}

	}

}