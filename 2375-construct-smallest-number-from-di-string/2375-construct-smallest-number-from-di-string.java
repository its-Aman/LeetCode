class Solution {
	public String smallestNumber(String pattern) {
		StringBuilder ans = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		char ch = '1';

		for (int i = 0; i < pattern.length(); i++) {
			temp.append(ch++);

			if (pattern.charAt(i) == 'I') {
				ans.append(temp.reverse());
				temp = new StringBuilder();
			}
		}

		ans.append(temp.append(ch++).reverse());
		return ans.toString();
	}
}