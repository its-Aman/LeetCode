class Solution {
	int[] root;
	int[] rank;

	private void buildUnion(int N) {
		this.root = new int[N];
		this.rank = new int[N];

		for (int i = 0; i < N; i++) {
			this.root[i] = i;
			this.rank[i] = 1;
		}
	}

	private int find(int x) {
		int temp = x;

		while (temp != this.root[temp])
			temp = this.root[temp];

//		path compression
		while (x != temp) {
			int next = this.root[x];
			this.root[x] = temp;
			x = next;
		}

		return temp;
	}

	private void union(int x, int y) {
		int xx = this.find(x);
		int yy = this.find(y);

		if (xx != yy) {
			if (this.rank[xx] > this.rank[yy]) {
				this.root[yy] = xx;
			} else if (this.rank[xx] < this.rank[yy]) {
				this.root[xx] = yy;
			} else {
				this.rank[xx] += 1;
				this.root[yy] = xx;
			}
		}
	}

	private Map<Integer, List<Integer>> getConnectedComponents() {
		Map<Integer, List<Integer>> connected = new HashMap<>();

		for (int i = 0; i < this.root.length; i++) {
			int parent = this.find(i);
			connected.putIfAbsent(parent, new ArrayList<Integer>());
			connected.get(parent).add(i);
		}

		return connected;
	}

	private String buildSmallestString(String S) {
		char[] sChar = S.toCharArray();

		for (List<Integer> connected : this.getConnectedComponents().values()) {
			char[] curr = new char[connected.size()];
			int i = 0;

			for (Integer idx : connected) {
				curr[i++] = sChar[idx];
			}

			Arrays.sort(curr);
			i = 0;

			for (Integer idx : connected) {
				sChar[idx] = curr[i++];
			}
		}

		return new String(sChar);
	}

	public String smallestStringWithSwaps(String S, List<List<Integer>> pairs) {
		int N = S.length();
		this.buildUnion(N);

		for (List<Integer> pair : pairs) {
			this.union(pair.get(0), pair.get(1));
		}

		return this.buildSmallestString(S);
	}}