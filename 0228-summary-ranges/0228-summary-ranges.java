class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            int x = nums[i], y = nums[i];
            
            while(i+1<nums.length && y+1 == nums[i+1]) {
                i++;
                y = nums[i];
            }
            
            if(x == y) {
                ans.add(String.valueOf(x));
            } else {
                ans.add(String.valueOf(x)+"->"+String.valueOf(y));
            }
        }
        
        return ans;
    }
}