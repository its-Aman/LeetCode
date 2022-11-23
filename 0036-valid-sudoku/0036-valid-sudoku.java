class Solution {
    public boolean isValidSudoku(char[][] B) {
        boolean[] setR = new boolean[10],
                    setC = new boolean[10],
                    setD = new boolean[10];

        for(int r = 0; r < 9; r++) {
            Arrays.fill(setR, false);
            Arrays.fill(setC, false);

            for(int c = 0; c < 9; c++) {
                char chR = B[r][c];
                if(chR != '.') {
                    if(setR[chR - '0'])
                        return false;
                    setR[chR-'0'] = true;
                }
                
                char chC = B[c][r];
                if(chC != '.') {
                    if(setC[chC - '0'])
                        return false;
                    setC[chC-'0'] = true;
                }
            }
        }

		for (int z = 0; z < 9; z++) {
			int dx = 3 * (z % 3);
			int dy = 3 * (z / 3);
	
            Arrays.fill(setD, false);

			for (int r = 0 + dx; r < 3 + dx; r++) {
                for (int c = 0 + dy; c < 3 + dy; c++) {
                    char chD = B[r][c];
					if (chD != '.') {
                        if (setD[chD - '0'])
                            return false;
                        setD[chD - '0'] = true;                        
                    }

				}
			}
		}        
        
        return true;
    }
}