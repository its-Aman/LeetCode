class Solution {
    public boolean isCircularSentence(String sentence) {
        var splitted = sentence.split(" ");
        int N = splitted.length;

        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].charAt(splitted[i].length() - 1) != splitted[(i + 1) % N].charAt(0))
                return false;
        }

        return true;
    }
}