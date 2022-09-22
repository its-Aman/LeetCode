class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String ans = "";

        for (int i = 0; i < s.length(); ) {
            int end = i + 1;
            while (end < s.length() && s.charAt(end) != ' ')
                end++;

            stringBuilder.setLength(0);
            stringBuilder.append(s, i, end);
            stringBuilder.reverse();
            if (end < s.length())
                stringBuilder.append(s.charAt(end));
            ans = ans.concat(stringBuilder.toString());
            i = ++end;
        }

        
        return ans;
    }

    public String reverseWords_split(String s) {
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