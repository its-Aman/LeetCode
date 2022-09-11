class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] count = new int[100_001];
        int freq = 0, ans = Integer.MIN_VALUE;

        for (int num : nums){
            if (num % 2 == 0) {
                ++count[num];
                
                if(count[num] > freq || count[num] == freq && num < ans) {
                    ans = num;
                    freq = count[num];
                }
            }
        }

        if(ans == Integer.MIN_VALUE)
            ans = -1;
        
        return ans;
    }
}