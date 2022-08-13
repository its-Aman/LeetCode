class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		int N = nums.length;

		for (int i = 0; i < Math.pow(2, N); i++) {
			List<Integer> curr = new ArrayList<>();
			int k = i;

			for (int j = 0; j < N; j++) {

				if (k == 0) {
					break;
				}

				if ((k & 1) == 1) {
					curr.add(nums[j]);
				}
				k >>= 1;
			}
			
			ans.add(curr);
		}
        
		return ans;
	}
}