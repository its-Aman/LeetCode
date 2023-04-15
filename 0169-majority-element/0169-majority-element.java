class Solution {
    public int majorityElement(int[] nums) {
        int x = nums[0], cnt = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == x) {
                cnt++;
            } else {
                cnt--;
            }
            
            if(cnt == 0) {
                x = nums[i];
                cnt = 1;
            }
        }
        
        return x;
    }
}