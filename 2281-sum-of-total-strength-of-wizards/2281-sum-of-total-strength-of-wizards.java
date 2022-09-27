// https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2062017/C++-prefix-+-monotonic-stack-O(N)-solution-with-thought-process/1418288

class Solution {
    public int totalStrength(int[] strength) {
        int MOD = 1_000_000_007;
        int N = strength.length;
        
        long[] prefix = new long[N + 1];
        long[] prefixSum = new long[N + 2];

        for(int i = 0; i < N; i++)
            prefix[i + 1] = (prefix[i] + strength[i]) % MOD;
        
        for(int i = 0; i <= N; i++)
            prefixSum[i + 1] = (prefix[i] + prefixSum[i]) % MOD;
        
        int[] left = new int[N];
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(left, -1);
        Arrays.fill(right, N);
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
    
            if(!stack.isEmpty())
                left[i] = stack.peek();
            
            stack.push(i);
        }

        long ans = 0;
        
        for(int i = 0; i < N; i++) {
            long positivePart = (prefixSum[right[i] + 1] - prefixSum[i + 1]) * (i - left[i]) % MOD;
            long negativePart = (prefixSum[i + 1] - prefixSum[left[i] + 1]) * (right[i] - i) % MOD;

            ans += (positivePart + (MOD * 2) - negativePart) * strength[i];
            ans %= MOD;
        }

        return (int)ans;
        
    }
}