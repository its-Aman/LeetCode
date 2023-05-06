class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007, N = nums.length;
        int ans = 0;
        
        Arrays.sort(nums);
        int[] pow = new int[N];

        pow[0]=1;
        
        for(int i=1; i<N; i++) {
            pow[i] = (pow[i-1]*2)%MOD;
        }
        
        for(int l=0, r=N-1; l<=r; ) {
            if(nums[l]+nums[r]<=target) {
                ans += pow[r-l]%MOD;
                ans %= MOD;
                l++;
            } else {
                r--;
            }
        }
        
        return ans;
    }
    
    public int numSubseq2(int[] nums, int target) {
        int MOD = 1_000_000_007;
        int ans = 0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
            int j = binarySearch(nums, target-nums[i]);
            if(j-1>=i) {
                int cnt = (1<<(j-1-i))%MOD;
                ans = (ans+cnt)%MOD;
            }
        }
        
        return ans;
    }
    
    private int binarySearch(int[] nums, int k) {
        int l=0, r=nums.length-1;
        
        while(l<=r) {
            int m = l+((r-l)>>1);
            if(nums[m]<=k) l = m+1;
            else r=m-1;
        }
        
        return l;
    }
}