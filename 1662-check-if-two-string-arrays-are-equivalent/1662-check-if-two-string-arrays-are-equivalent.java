class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        return String.join("", word1).equals(String.join("", word2));
        int p1 = 0, p2 = 0;
        int w1 = 0, w2 = 0;

        while (w1 < word1.length && w2 < word2.length) {
            String curr1 = word1[w1], curr2 = word2[w2];

            if (curr1.charAt(p1) != curr2.charAt(p2))
                return false;

            if (p1 < curr1.length() - 1) {
                ++p1;
            } else {
                ++w1;
                p1 = 0;
            }

            if (p2 < curr2.length() - 1) {
                ++p2;
            } else {
                ++w2;
                p2 = 0;
            }
        }

        return w1 == word1.length && w2 == word2.length;
    }
}