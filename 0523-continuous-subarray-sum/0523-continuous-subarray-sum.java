class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;
        
        for(int i = 1; i < N; i++)
            if(nums[i] == 0 && nums[i - 1] == 0)
                return true;
        
        for(int i = 1; i < N; i++) {
            nums[i] += nums[i-1];
            
            if(nums[i]%k == 0) return true;
            
            int j = i;
            
            while(j > 1 && nums[i] > k) {
                if((nums[i] - nums[j - 2])%k == 0)
                    return true;
                j--;
            }
        }
        
        return false;
    }    
    
//     public boolean checkSubarraySum(int[] nums, int k) {
//         int N = nums.length, sum = 0;
//         Map<Integer, Integer> map = new HashMap<>();

//         map.put(0, sum);
//         for(int i = 0; i < N; i++) {
//             sum += nums[i];
            
//             if(!map.containsKey(sum%k))
//                 map.put(sum%k, i+1);
//             else if(map.get(sum%k) < i)
//                 return true;
//         }
        
//         return false;
//     }
}