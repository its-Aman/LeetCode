class Solution {

    public int longestConsecutive(int[] nums) {
		DisjointSet dsu = new DisjointSet(nums.length);
		Map<Integer, Integer> value2index = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (value2index.containsKey(nums[i]))
				continue;

			if (value2index.containsKey(nums[i] - 1))
				dsu.union(i, value2index.get(nums[i] - 1));

			if (value2index.containsKey(nums[i] + 1))
				dsu.union(i, value2index.get(nums[i] + 1));

			value2index.put(nums[i], i);
		}

		return dsu.getLargestComponentSize();
	}

	public int longestConsecutive_hashmap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		int max = 0;

		for (int num : nums)
			set.add(num);

		for (int num : set) {
			int currMax = map.getOrDefault(num - 1, 0) + 1 + map.getOrDefault(num + 1, 0);

			map.put(num, currMax);
			map.put(num - map.getOrDefault(num - 1, 0), currMax);
			map.put(num + map.getOrDefault(num + 1, 0), currMax);

			max = Math.max(max, currMax);
		}

		return max;
	}
}

class DisjointSet {
	private int[] parent;
	private int[] size;

	public DisjointSet(int n) {
		this.parent = new int[n];
		this.size = new int[n];

		while (n-- > 0) {
			this.parent[n] = n;
			this.size[n] = 1;
		}
	}

	public void union(int x, int y) {
		int xx = this.find(x), yy = this.find(y);

		if (xx != yy) {
			this.parent[xx] = yy;
			this.size[yy] += this.size[xx];
		}
	}

	public int find(int x) {
		if (this.parent[x] == x)
			return x;

		return this.parent[x] = this.find(this.parent[x]);
	}

	public int getLargestComponentSize() {
		int max = 0;

		for (int i = 0; i < this.parent.length; i++)
			if (this.parent[i] == i && this.size[i] > max)
				max = this.size[i];

		return max;
	}
}