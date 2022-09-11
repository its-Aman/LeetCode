class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int freq = 0, ans = Integer.MIN_VALUE;

        for (int num : nums){
            if (num % 2 == 0) {
                
                int curr = 1 + map.getOrDefault(num, 0);
                map.put(num, curr);
                
                if(curr > freq || curr == freq && num < ans) {
                    ans = num;
                    freq = curr;
                }
            }
        }

        if(ans == Integer.MIN_VALUE)
            ans = -1;
        
        return ans;
    }
}