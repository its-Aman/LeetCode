class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";

        if(n == 1) return "1";
        
        String ans = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        int freq = 0;            
        
        for(int i = 0; i < ans.length(); i++) {
            freq++;

            if(i + 1 == ans.length() || ans.charAt(i) != ans.charAt(i + 1)) {
                sb.append(freq);
                sb.append(ans.charAt(i));
                freq = 0;
            }
            
        }
        
        return sb.toString();
    }
}