class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        return largestOverlap_LinearTransformation(img1, img2);
    }
    
    protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int leftShiftCount = 0, rightShiftCount = 0;
        int rRow = 0;
        // count the cells of ones in the overlapping zone.
        for (int mRow = yShift; mRow < M.length; ++mRow) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; ++mCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount += 1;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount += 1;
                rCol += 1;
            }
            rRow += 1;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public int largestOverlap_BruteForce(int[][] A, int[][] B) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < A.length; ++yShift)
            for (int xShift = 0; xShift < A.length; ++xShift) {
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
            }

        return maxOverlaps;
    }

    public int largestOverlap_LinearTransformation(int[][] A, int[][] B) {
        List<int[]> oneA = getNonZero(A), oneB = getNonZero(B);
        int ans = 0;
        Map<Integer, Map<Integer, Integer>> count = new HashMap<>();

        for (int[] a : oneA) {
            for (int[] b : oneB) {
                int x = b[0] - a[0], y = b[1] - a[1];
                int X = count.computeIfAbsent(x, k -> new HashMap<>()).getOrDefault(y, 0);
                count.get(x).put(y, X + 1);
                ans = Math.max(ans, count.get(x).get(y));
            }
        }

        return ans;
    }

    private List<int[]> getNonZero(int[][] M) {
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M.length; c++) {
                if (M[r][c] == 1)
                    list.add(new int[]{r, c});
            }
        }
        return list;
    }
}