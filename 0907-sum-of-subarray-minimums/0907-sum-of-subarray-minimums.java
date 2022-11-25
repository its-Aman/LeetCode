class Solution {
    public int sumSubarrayMins(int[] arr) {
        return sumSubarrayMins_stackOnly(arr);
    }

    public int sumSubarrayMins_stackAndDP(int[] arr) {
        int MOD = 1000000007;
        int N = arr.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[N];
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            
            if(stack.isEmpty())
                dp[i] = (i + 1) * arr[i];
            else 
                dp[i] = dp[stack.peek()] + (i - stack.peek()) * arr[i];
            
            stack.push(i);
        }
        
        for(int cnt : dp)
            ans = (ans + cnt) % MOD;
        
        return ans;
    }
    
    public int sumSubarrayMins_stackOnly(int[] arr) {
        int MOD = 1000000007;
        int N = arr.length;
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i <= N; i++) {
            while(!stack.isEmpty() && (i == N || arr[stack.peek()] >= arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();

                long cnt = (mid - left) * (i - mid) % MOD;
                ans += (cnt * arr[mid]) % MOD;
                ans %= MOD;
            }
            
            stack.push(i);
        }

        return (int)ans;
    }
}