class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }

        int N = s.length();
        String ans = s, doubleS = s + s;
        for (int i = 1; i < N; i++) {
            String temp = doubleS.substring(i, i + N);
            if (ans.compareTo(temp) > 0)
                ans = temp;
        }
        return ans;
    }
}