class Solution {
    public int compress(char[] chars) {
        int N = chars.length, i = 0, res = 0;
        
        while(i < N) {
            int j = 1;
            
            while(i + j < N && chars[i] == chars[i + j]) {
                j++;
            }
            
            chars[res++] = chars[i];
            i += j;

            if(j == 1) {
                continue;
            }
            
            for(char c: Integer.toString(j).toCharArray()){
                chars[res++] = c;
            }
        }

        return res;
    }
}