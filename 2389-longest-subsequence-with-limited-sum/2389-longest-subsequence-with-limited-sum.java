class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int N = nums.length,
                M = queries.length;
        int[] ans = new int[M];

        Arrays.sort(nums);

        for (int i = 1; i < N; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < M; i++) {
            int idx = binarySearch(nums, queries[i]);
            ans[i] = idx;
        }

        return ans;
    }
    
    private int binarySearch(int[] nums, int x) {
        int l = 0, r = nums.length - 1;
        
        while(l < r) {
            int m = (l + r) >> 1;
            
            if(nums[m] == x) {
                return m + 1;
            } else if(nums[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        if(nums[l] <= x) {
            l += 1;
        }
        
        return l;
    }
}