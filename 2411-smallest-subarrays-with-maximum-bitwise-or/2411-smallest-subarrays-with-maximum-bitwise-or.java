class Solution {
    public int[] smallestSubarrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        // consider num as binary number. the array save the latest index for each bit 1 appear.
        // for example : if curr number is nums[3] = 5, 5 -> (101), lastBitOneIndex[0] = 3, lastBitOneIndex[2] = 3.
        int[] lastBitOneIndex = new int[32]; // 30 is enough cause 0 <= nums[i] <= 10^9
        Arrays.fill(lastBitOneIndex, -1); 
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = n - 1; i >= 0; i--) { // we need to find the subarray from i , so we need to update the nums after i before we check nums[i]
            for (int j = 0; j < 32; j++) { // check from the most right bit, update it's index if it is 1
                int currChecker = 1 << j;
                if ((nums[i] & currChecker) > 0) { // means from right , bit at index j is 1, then update index here cause we want to find minimum length
                    lastBitOneIndex[j] = i;
                }
                if (lastBitOneIndex[j] != -1) { // if we find curr bit is 1 , means we find a large bitwise OR result, update max length
                    res[i] = Math.max(res[i], lastBitOneIndex[j] - i + 1);
                }
            }
        }
        return res;
    }}