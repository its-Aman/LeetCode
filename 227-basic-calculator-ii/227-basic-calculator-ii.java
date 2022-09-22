class Solution {
    public int calculate(String s) {
        s = s.concat("+");
        int N = s.length(),
                total = 0,
                prev = 0,
                curr = 0;
        char op = '+';

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c))
                continue;

            if ("+-/*".indexOf(c) == -1) {
                curr = curr * 10 + (c - '0');
                continue;
            }

            switch (op) {
                case '+':
                    total += prev;
                    prev = curr;
                    break;
                case '-':
                    total += prev;
                    prev = -curr;
                    break;
                case '/':
                    prev /= curr;
                    break;
                case '*':
                    prev *= curr;
                    break;
            }
            
            curr = 0;
            op = c;
        }


        return total + prev;
    }
}