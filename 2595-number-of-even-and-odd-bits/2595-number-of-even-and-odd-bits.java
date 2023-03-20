class Solution {
    public int[] evenOddBit(int n) {
        int idx = 0, e = 0, o = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (idx % 2 == 0) {
                    e++;
                } else {
                    o++;
                }
            }
            idx++;
            n >>= 1;
        }

        return new int[]{e, o};
    }
}