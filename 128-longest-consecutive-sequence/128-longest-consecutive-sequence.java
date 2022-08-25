class Solution {
    
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        
        for(int num: nums)
            set.add(num);

        for(int num: nums) {
            
            if(!set.contains(num - 1)) {
                int currNum = num, streak = 1;
                
                while(set.contains(++currNum))
                    streak++;
                
                max = Math.max(streak, max);
            }
        }

        return max;
    }
}