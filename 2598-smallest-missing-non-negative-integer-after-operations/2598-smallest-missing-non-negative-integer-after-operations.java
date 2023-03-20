// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/discuss/3313988/Count-Moduli

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mod = new int[100000];
        
        for (int num : nums) {
            mod[((num % value) + value) % value]++;
        }
    
        for (int i = 0; i < nums.length; i++){
            if (--mod[i % value] < 0) {
                return i;
            };
        }
        
        return nums.length;    
    }
}