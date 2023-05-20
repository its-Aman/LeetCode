class Solution {
	Map<String, String> root = new HashMap<>();
	Map<String, Double> dist = new HashMap<>();

	private String find(String s) {
		if (!this.root.containsKey(s)) {
			this.root.put(s, s);
			this.dist.put(s, 1.0);
			return s;
		}

		if (this.root.get(s).equals(s)) {
			return s;
		}

//		Path Compression
		String lastParent = this.root.get(s), newParent = this.find(lastParent);

		if (!lastParent.equals(newParent)) {
			this.root.put(s, newParent);
			this.dist.put(s, this.dist.get(s) * this.dist.get(lastParent));
		}

		return newParent;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int N = equations.size();
		int M = queries.size();
		double[] ans = new double[M];

		for (int i = 0; i < N; i++) {
			String x = equations.get(i).get(0), y = equations.get(i).get(1);
            
			String xx = this.find(x), yy = this.find(y);

			this.root.put(xx, yy);
			this.dist.put(xx, this.dist.get(y) * values[i] / this.dist.get(x));
		}

		for (int i = 0; i < M; i++) {
            String x = queries.get(i).get(0), y = queries.get(i).get(1);

			if (!this.root.containsKey(x) || !this.root.containsKey(y) || !this.find(x).equals(this.find(y))) {
				ans[i] = -1.0;
			} else {
				ans[i] = this.dist.get(x) / this.dist.get(y);
			}

		}

		return ans;
	}
}