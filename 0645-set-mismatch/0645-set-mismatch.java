class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int N = nums.length;
        int[] ans = new int[2];
        
        long sum = N*(N+1)/2;
        long allSum = 0;
        
        for(int num: nums) {
            if(set.contains(num)) {
                ans[0] = num;
            } else {
                set.add(num);
            }

            allSum += num;   
        }
        
        ans[1] = (int)sum - (int)allSum + ans[0];
        
        return ans;
    }
}