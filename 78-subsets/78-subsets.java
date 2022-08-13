class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();

		this.backtrack(0, new Stack<Integer>(), ans, nums);

		return ans;
	}

	private void backtrack(int idx, Stack<Integer> curr, List<List<Integer>> ans, int[] nums) {
		if (idx > nums.length)
			return;

		ans.add(new LinkedList<>(curr));

		for (int i = idx; i < nums.length; i++) {
			curr.push(nums[i]);
			this.backtrack(i + 1, curr, ans, nums);
			curr.pop();
		}

	}
}