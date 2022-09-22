class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String ans = "";

        String[] splits = s.split(" ");

        for (int i = 0; i < splits.length; i++) {
            stringBuilder.setLength(0);
            stringBuilder.append(splits[i]);
            stringBuilder.reverse();
            ans = ans.concat(stringBuilder.toString());
            if (i < splits.length - 1)
                ans = ans.concat(" ");
        }

        return ans;
    }
}