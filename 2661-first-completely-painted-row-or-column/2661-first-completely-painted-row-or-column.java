class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int R = mat.length;
        int C = mat[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map.put(mat[r][c], new int[]{r, c});
            }
        }
        
        int[] row = new int[R], col = new int[C];

        for (int i = 0; i < arr.length; i++) {
            int[] idx = map.get(arr[i]);
            row[idx[0]]++;
            col[idx[1]]++;

            if (row[idx[0]] == C || col[idx[1]] == R) {
                return i;
            }
        }

        return -1;
    }
}