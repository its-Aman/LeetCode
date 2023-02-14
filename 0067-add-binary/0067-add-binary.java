class Solution {
    public String addBinary(String a, String b) {
        int aN = a.length() - 1, bN = b.length() - 1, c = 0;

        StringBuilder sb = new StringBuilder();

        while (bN >= 0 || aN >= 0) {            
            int sum = c;

            if (bN >= 0) {
                sum += b.charAt(bN) - '0';
            }

            if (aN >= 0) {
                sum += a.charAt(aN) - '0';
            }

            sb.append(sum % 2);
            c = sum / 2;
            aN--;
            bN--;
        }

        if (c == 1) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
    
    
    public String addBinary2(String a, String b) {
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