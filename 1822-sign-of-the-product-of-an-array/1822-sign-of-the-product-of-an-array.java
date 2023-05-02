class Solution {
    public int arraySign(int[] nums) {
        int n = 0;
        
        for(int num: nums) {
            if(num == 0) {
                return 0;
            } else if(num < 0) {
                n++;
            }
        }

        if(n%2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}