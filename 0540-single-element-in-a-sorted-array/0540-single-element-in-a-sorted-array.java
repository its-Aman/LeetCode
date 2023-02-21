class Solution {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length, l = 0, r = N;
        
        if(N == 1) {
            return nums[0];
        } else if(N > 1) {
            if(nums[0] != nums[1]) {
                return nums[0];
            }
            
            if(nums[N-1] != nums[N-2]) {
                return nums[N-1];
            }
        }
        
        while(l < r) {
            int m = l + ((r-l)>>1);

            if((m-1 >=0 && nums[m] != nums[m-1]) && (m+1<N && nums[m] != nums[m+1])) {
                return nums[m];
            }
            
            if(m+1<N && m%2==0 && nums[m+1] == nums[m]) {
                l = m + 1;
            } else if(m-1>=0 && m%2==1 && nums[m-1] == nums[m]) {
                l = m + 1;                
            } else {
                r = m;
            }
            
        }
        
        return l;
    }
}