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
		String lastP = this.root.get(s);
		String p = this.find(lastP);

		if (lastP != p) {
			this.root.put(s, p);
			this.dist.put(s, this.dist.get(s) * this.dist.get(lastP));
		}
        
		return p;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int N = equations.size();
		int M = queries.size();
		double[] ans = new double[M];

		for (int i = 0; i < N; i++) {
			List<String> eq = equations.get(i);

			String x = eq.get(0);
			String y = eq.get(1);

			String xx = this.find(x);
			String yy = this.find(y);

			this.root.put(xx, yy);
			this.dist.put(xx, this.dist.get(y) * values[i] / this.dist.get(x));
		}

		for (int i = 0; i < M; i++) {
			List<String> q = queries.get(i);
			String x = q.get(0);
			String y = q.get(1);

			if (!this.root.containsKey(x) || !this.root.containsKey(y)) {
				ans[i] = -1.0;
				continue;
			}

			String xx = this.find(x);
			String yy = this.find(y);

			if (!xx.equals(yy)) {
				ans[i] = -1.0;
				continue;
			}

			ans[i] = this.dist.get(x) / this.dist.get(y);
		}

		return ans;
	}
}