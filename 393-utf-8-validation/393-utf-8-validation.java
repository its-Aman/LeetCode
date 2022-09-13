class Solution {
    public boolean validUtf8(int[] data) {
        int numberOfByteToProcess = 0;

        for (int i = 0; i < data.length; i++) {
            String curr_utf_8 = getByte(data[i]);

            if (numberOfByteToProcess == 0) {
                while (numberOfByteToProcess < curr_utf_8.length() && curr_utf_8.charAt(numberOfByteToProcess) != '0')
                    ++numberOfByteToProcess;

                if (numberOfByteToProcess == 0)
                    continue;

                if (numberOfByteToProcess > 4 || numberOfByteToProcess == 1)
                    return false;

            } else {
                if (curr_utf_8.charAt(0) != '1' || curr_utf_8.charAt(1) != '0')
                    return false;
            }
            --numberOfByteToProcess;
        }

        return numberOfByteToProcess == 0;
    }

    private String getByte(int num) {
        String bits = Integer.toBinaryString(num);

        if (bits.length() >= 8)
            bits = bits.substring(bits.length() - 8);
        else
            bits = "0".repeat(8 - bits.length()).concat(bits);

        return bits;
    }
}