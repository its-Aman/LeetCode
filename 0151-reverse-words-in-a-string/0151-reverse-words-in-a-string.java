class Solution {
    public String reverseWords_my(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (var ss : s.trim().split(" "))
            if (!ss.isEmpty())
                stack.push(ss.trim());

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (stack.size() > 0)
                sb.append(" ");
        }

        return sb.toString();
    }
    
    public String reverseWords(String s) {
        if (s == null)
            return s;

        char[] c = s.toCharArray();
        int N = c.length;

        reverse(c, 0, N - 1);

        reverseWords(c, N);

        return cleanSpaces(c, N);
    }

    private String cleanSpaces(char[] c, int N) {
        int i = 0, j = 0;

        while (j < N) {
            while (j < N && c[j] == ' ') j++;
            while (j < N && c[j] != ' ') c[i++] = c[j++];
            while (j < N && c[j] == ' ') j++;
            if (j < N) c[i++] = ' ';
        }
        return new String(c).substring(0, i);
    }

    private void reverseWords(char[] c, int N) {
        int i = 0, j = 0;

        while (i < N) {
            while (i < j || i < N && c[i] == ' ') i++;
            while (j < i || j < N && c[j] != ' ') j++;
            reverse(c, i, j - 1);
        }
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }
    
}