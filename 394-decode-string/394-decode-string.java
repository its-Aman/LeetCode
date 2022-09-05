class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++)
            q.offer(s.charAt(i));

        return this.decodeString(q);
    }

    private String decodeString(Queue<Character> q) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (!q.isEmpty()) {
            char c = q.poll();

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                sb.append(this.decodeString(q).repeat(num));
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}