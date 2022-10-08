class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        int sum = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int first = 0; first < N - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;

            int second = first + 1, third = N - 1;

            while (second < third) {
                int currSum = nums[first] + nums[second] + nums[third];

                if (currSum == target)
                    return target;

                if (Math.abs(target - currSum) < Math.abs(target - sum))
                    sum = currSum;

                if (currSum > target)
                    --third;

                if (currSum < target)
                    ++second;
            }
        }

        return sum;
    }
}
