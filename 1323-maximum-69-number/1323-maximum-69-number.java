class Solution {
    public int maximum69Number (int num) {
        char[] chNum = Integer.toString(num).toCharArray();
        
        for(int i = 0; i < chNum.length; i++) {
            if(chNum[i] == '6') {
                chNum[i] = '9';
                return Integer.parseInt(String.valueOf(chNum));
            }
        }
        
        return num;
    }
}