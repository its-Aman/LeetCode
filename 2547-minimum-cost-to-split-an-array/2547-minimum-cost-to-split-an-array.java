class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // base case (initialization case)
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            // Map<Integer, Integer> freq = new HashMap<>();
            int[] freq = new int[n]; 
            int uniquesCount = 0;

            for(int j = i; j < n; j++) {
                int val = nums[j];
                int valFreq = freq[val];
                
                if(valFreq == 0) uniquesCount++;
                if(valFreq == 1) uniquesCount--;
                
                int trimmedCnt = (j - i + 1) - uniquesCount;
                
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + trimmedCnt + k);
                freq[val] = valFreq + 1;
            }
        }

        return dp[n];
    }    
    
//     Map<Integer, Integer> cnt = new HashMap<>();

//     public int minCost(int[] nums, int k) {
//         System.out.println();
//         int ans = Integer.MAX_VALUE;
//         int N = nums.length;
//         int[][] dp = new int[N][N];

//         for (int i = 0; i < N; i++) {
//             for (int j = i + 1; j < N; j++) {
//                 dp[i][j] = getTrimmedLength(nums, i, j);
//             }
//             System.out.println(Arrays.toString(dp[i]));
//         }

//         for (int gap = 0; gap < N; gap++) {
//             int curr = 0, idx = 0;

//             while (idx < N) {
//                 System.out.printf("%d\t%d\n", idx, idx + gap);
//                 curr += dp[idx][Math.min(idx + gap, N - 1)];
//                 idx += gap + 1;
//             }
            
//             curr += k * (N - gap);
//             System.out.println(curr);
//             ans = Math.min(ans, curr);
//         }

//         return ans;
//     }

//     private int getTrimmedLength(int[] nums, int start, int end) {
//         // System.out.printf("start: %d\tend:%d\n", start, end);
//         cnt.clear();

//         while (start <= end) {
//             cnt.put(nums[start], cnt.getOrDefault(nums[start], 0) + 1);
//             start++;
//         }

//         int sum = 0;

//         for (int k : cnt.keySet()) {
//             int curr = cnt.get(k);
//             if (curr > 1) {
//                 sum += curr;
//             }
//         }

//         return sum;
//     }
}