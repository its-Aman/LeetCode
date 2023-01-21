class Solution {
    List<String> ans = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        findIPs(s, 0, "", 0);
        return ans;
    }

    private void findIPs(String s, int idx, String curr, int dotCnt) {

        if (idx >= s.length() && (curr.length() - s.length() == 3)) {
            ans.add(curr);
            return;
        }

        if (idx + 1 <= s.length()) {
            goNext(s, idx, 1, curr, dotCnt);
        }

        if (idx + 2 <= s.length()) {
            goNext(s, idx, 2, curr, dotCnt);
        }

        if (idx + 3 <= s.length()) {
            goNext(s, idx, 3, curr, dotCnt);
        }
    }

    private void goNext(String s, int idx, int x, String curr, int dotCnt) {
        int num = Integer.parseInt(s.substring(idx, idx + x));
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append(curr);
        if (dotCnt > 0) {
            sb.append('.');
        }
        sb.append(num);
        if (num >= 0 && num <= 255 && dotCnt < 4) {
            findIPs(s, idx + x, sb.toString(), dotCnt + 1);
        }
    }
}