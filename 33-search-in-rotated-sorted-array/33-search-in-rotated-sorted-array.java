class Solution {
  public int search(int[] nums, int target) {
    int N = nums.length;
    int lo = 0;
    int hi = N - 1;
    
    while(lo <= hi) {
      int mid = lo + (hi-lo) / 2;
      
      if(target == nums[mid]) {
        
        return mid;
        
      } else if(nums[lo] <= nums[mid]) {
        
        if(target > nums[mid] || target < nums[lo]) {

          lo = mid + 1;

        } else {

          hi = mid - 1;
        
        }
          
      } else {

        if(target < nums[mid] || target > nums[hi]) {
          
          hi = mid - 1;

        } else {
        
          lo = mid + 1;

        }
      }
    }
    
    return -1;
  }
}