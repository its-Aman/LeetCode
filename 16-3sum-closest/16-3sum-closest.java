class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;

        Arrays.sort(nums);
        
        int sum = nums[0] + nums[1] + nums[2];
        
        for(int first = 0; first < N - 2; first++) {
            if(first > 0 && nums[first] == nums[first - 1])
                continue;
            
            int second = first + 1;
            int third = N - 1;
            
            while(second < third) {
                int currSum = nums[first] + nums[second] + nums[third];

                if(currSum == target)
                    return currSum;
                
                if(Math.abs(target - currSum) < Math.abs(target - sum))
                    sum = currSum;
                
                if(currSum > target)
                    --third;
                
                if(currSum < target)
                    ++second;
            }
        }

        return sum;
    }
}