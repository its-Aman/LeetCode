class Solution {
//     public int subarrayGCD(int[] nums, int k) {
//         int ans = 0;
//         int N = nums.length;
        
        
//         for(int i = 0; i < N; i++) {
//             int curr = 0;
            
//             for(int j = i; j < N; j++) {
//                 curr = gcd(curr, nums[j]);
                
//                 if(curr == k)
//                     ans++;
//             }
//         }
        
        
//         return ans;
//     }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, Math.abs(a - b));
    }
    
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> tempMap = new HashMap<>();
            if (nums[i] % k == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

                for (var key : map.keySet()) {
                    int curr = gcd(key, nums[i]);
                    tempMap.put(curr, tempMap.getOrDefault(curr, 0) + map.get(key));
                }
            }

            ans += tempMap.getOrDefault(k, 0);
            map = tempMap;
        }

        return ans;
    }

}