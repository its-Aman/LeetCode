class Solution {
    public String addBinary(String a, String b) {
        int aN = a.length(), bN = b.length(), c = 0;

        if (bN > aN) {
            return addBinary(b, a);
        }

        Stack<String> ans = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (bN-- > 0) {
            aN--;

            int aa = a.charAt(aN) - '0',
                    bb = b.charAt(bN) - '0';

            int curr = aa + bb + c;

            ans.push(String.valueOf(curr % 2));
            c = curr < 2 ? 0 : 1;
        }

        while (aN-- > 0) {
            int aa = a.charAt(aN) - '0';

            int curr = aa + c;

            ans.push(String.valueOf(curr % 2));
            c = curr < 2 ? 0 : 1;

            if (c == 0) {
                while (!ans.isEmpty()) {
                    sb.append(ans.pop());
                }
                return a.substring(0, aN) + sb;
            }
        }

        if (c == 1) {
            ans.push("1");
        }
        
        while (!ans.isEmpty()) {
            sb.append(ans.pop());
        }

        return sb.toString();
    }
}