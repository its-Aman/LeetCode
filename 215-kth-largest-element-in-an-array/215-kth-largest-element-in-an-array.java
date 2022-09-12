class Solution {
    Random random = new Random();
    
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int num: nums)
            list.add(num);
        
        return findKthLargest(list, k);
    }
    
    public int findKthLargest(List<Integer> nums, int k) {
        if(nums == null || nums.size() == 0)
            return 0;
        
        int pivot = nums.get(random.nextInt(nums.size()));
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for(int num: nums) {
            if(num > pivot)
                left.add(num);
            else if(num < pivot)
                right.add(num);
            else
                mid.add(num);
        }
        
        int L = left.size();
        int M = mid.size();
        
        if(k <= L)
            return findKthLargest(left, k);
        else if(k > L + M)
            return findKthLargest(right, k - L - M);
        else
            return mid.get(0);        
    }

}
