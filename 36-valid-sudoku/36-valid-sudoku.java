class Solution {
	public boolean isValidSudoku(char[][] board) {
		// checking rows and cols

		for (int r = 0; r < 9; r++) {

			boolean[] cFlag = new boolean[10];

			for (int c = 0; c < 9; c++) {
				if (board[r][c] == '.')
					continue;

				if (cFlag[board[r][c] - '0'])
					return false;
				else
					cFlag[board[r][c] - '0'] = true;

			}

		}

		for (int r = 0; r < 9; r++) {

			boolean[] rFlag = new boolean[10];

			for (int c = 0; c < 9; c++) {
				if (board[c][r] == '.')
					continue;

				if (rFlag[board[c][r] - '0'])
					return false;
				else
					rFlag[board[c][r] - '0'] = true;
			}

		}

		// checking 3X3

		for (int z = 0; z < 9; z++) {
			int dx = 3 * (z % 3);
			int dy = 3 * (z / 3);

			boolean[] subFlag = new boolean[10];

			for (int r = 0 + dx; r < 3 + dx; r++) {
				for (int c = 0 + dy; c < 3 + dy; c++) {
					if (board[r][c] == '.')
						continue;

					if (subFlag[board[r][c] - '0'])
						return false;
					else
						subFlag[board[r][c] - '0'] = true;
				}
			}
		}

		return true;
	}
}