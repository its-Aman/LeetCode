class Solution {
	private Set<String> visited = new HashSet<>();
	private Map<String, List<String>> adjecent = new HashMap<>();

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		for (List<String> account : accounts) {
			String firstEmail = account.get(1);

			for (int i = 2; i < account.size(); i++) {
				String currEmail = account.get(i);

				this.adjecent.putIfAbsent(firstEmail, new ArrayList<>());
				this.adjecent.get(firstEmail).add(currEmail);

				this.adjecent.putIfAbsent(currEmail, new ArrayList<>());
				this.adjecent.get(currEmail).add(firstEmail);

			}
		}

		List<List<String>> mergedAccounts = new ArrayList<>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			String firstEmail = account.get(1);

			if (this.visited.contains(firstEmail)) {
				continue;
			}

			List<String> mergedAccount = new ArrayList<>();
			mergedAccount.add(name);

			this.DFS(mergedAccount, firstEmail);

			Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
			mergedAccounts.add(mergedAccount);
		}

		return mergedAccounts;
	}

	private void DFS(List<String> mergedAccount, String email) {
		this.visited.add(email);
		mergedAccount.add(email);

		if (!this.adjecent.containsKey(email)) {
			return;
		}

		for (String otherEmail : this.adjecent.get(email)) {
			if (!this.visited.contains(otherEmail)) {
				this.DFS(mergedAccount, otherEmail);
			}
		}
	}
}
