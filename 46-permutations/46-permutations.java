class Solution {
	public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> ans = new LinkedList<>();
		boolean[] used = new boolean[nums.length];

		this.backtrack(nums, ans, new ArrayList<>(), used);

		return ans;

	}

	private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] used) {

		if (curr.size() == nums.length) {
			ans.add(List.copyOf(curr));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;

			used[i] = true;
			curr.add(nums[i]);
			this.backtrack(nums, ans, curr, used);
			curr.remove(curr.size() - 1);
			used[i] = false;
		}

	}

}