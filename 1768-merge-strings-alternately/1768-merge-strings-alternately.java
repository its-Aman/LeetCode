class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int N1 = word1.length(), N2 = word2.length();
        int i=0, j=0;
        boolean flag = true;
        
        while(i<N1 && j<N2) {
            if(flag) {
                sb.append(word1.charAt(i++));
            } else {
                sb.append(word2.charAt(j++));
            }
            flag = !flag;
        }
        
        while(i < N1) {
            sb.append(word1.charAt(i++));
        }

        while(j < N2) {
            sb.append(word2.charAt(j++));
        }
        
        return sb.toString();
    }
}