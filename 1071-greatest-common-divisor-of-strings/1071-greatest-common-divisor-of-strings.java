class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int N1 = str1.length(),
            N2 = str2.length();
        
        if(N2 < N1) {
            return gcdOfStrings(str2, str1);
        }
        
        // System.out.println(str1 + "\t" + str2);
        
        String ans = "";
        
        for(int i = 1; i <= N1; i++) {
            String sub = str1.substring(0, i);
            boolean isAll = true;
            // System.out.println(sub + "\t" + ans);

            for(int j = 0; j < N1 && isAll; j+=i) {
                isAll &= sub.equals(str1.substring(j, Math.min(N1,j+i)));
            }
            
            for(int j = 0; j < N2 && isAll; j+=i) {
                isAll &= sub.equals(str2.substring(j, Math.min(N2,j+i)));
            }
            
            if(isAll && sub.length() > ans.length()) {
                ans = sub;
            }
        }
        
        return ans;
    }
}