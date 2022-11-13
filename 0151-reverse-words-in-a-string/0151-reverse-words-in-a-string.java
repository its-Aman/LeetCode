class Solution {
    public String reverseWords(String s) {
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
}