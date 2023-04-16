class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx = -1, cnt = 0;

        for (int i = mat.length - 1; i >= 0; i--) {
            int curr = 0;

            for (int j = 0; j < mat[0].length; j++) {
                curr += mat[i][j];
            }

            if (curr >= cnt) {
                cnt = curr;
                idx = i;
            }
        }
        return new int[]{idx, cnt};
    }

}