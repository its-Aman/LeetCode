class Solution {
    
    	public String shiftingLetters(String S, int[][] shifts) {
		char[] cs = S.toCharArray();
		int[] line = new int[S.length() + 1];

		for (int[] s : shifts) {
			line[s[0]] += s[2] == 1 ? 1 : -1;
			line[s[1] + 1] += s[2] == 1 ? -1 : 1;
		}

		for (int i = 0, val = 0; i < S.length(); i++) {
			val = (val + line[i]) % 26;
			cs[i] = (char) ('a' + (26 + (cs[i] - 'a') + val) % 26);
		}

		return new String(cs);
	}
    
// 	public String shiftingLetters(String S, int[][] shifts) {
// 		char[] cs = S.toCharArray();

// 		for (int[] shift : shifts) {
// 			int s = shift[0];
// 			int e = shift[1];
// 			int d = shift[2];

// 			while (s <= e) {

// 				if (d == 1) { // forward
// 					if (cs[s] == 'z')
// 						cs[s] = 'a';
// 					else
// 						cs[s] += 1;
// 				} else { // backward
// 					if (cs[s] == 'a')
// 						cs[s] = 'z';
// 					else
// 						cs[s] -= 1;
// 				}

// 				s += 1;
// 			}
// 		}

// 		return new String(cs);
// 	}
}