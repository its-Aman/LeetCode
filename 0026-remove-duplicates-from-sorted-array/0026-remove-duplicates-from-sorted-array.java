class Solution {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        SortedSet<Integer> set = new TreeSet<>();
        int j = 0;
        
        for(int i = 0; i < N; i++)
            set.add(nums[i]);

        int k = set.size();
        int i = 0;
        
        for(int num: set)
            nums[i++] = num;
        
        return k;
    }
}