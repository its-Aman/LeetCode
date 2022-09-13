class Solution {
    public boolean validUtf8(int[] data) {
        int numberOfByteToProcess = 0;
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;

        for (int i = 0; i < data.length; i++) {
            if (numberOfByteToProcess == 0) {
                int mask = 1 << 7;

                while ((mask & data[i]) != 0) {
                    ++numberOfByteToProcess;
                    mask >>= 1;
                }

                if (numberOfByteToProcess == 0)
                    continue;

                if (numberOfByteToProcess > 4 || numberOfByteToProcess == 1)
                    return false;

            } else {
                if ((mask1 & data[i]) == 0 || (mask2 & data[i]) != 0)
                    return false;
            }
            --numberOfByteToProcess;
        }

        return numberOfByteToProcess == 0;
    }
}