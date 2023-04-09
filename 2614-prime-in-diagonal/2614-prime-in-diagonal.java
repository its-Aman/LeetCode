class Solution {
//     public int diagonalPrime(int[][] nums) {
//         int N = nums.length;
//         long ans = Long.MIN_VALUE;
//         int max = Integer.MIN_VALUE;

//         for (var r : nums) {
//             for (var c : r) {
//                 max = Math.max(max, c);
//             }
//         }

//         boolean[] primes = sieveOfEratosthenes(max);

//         for (int i = 0; i < N; i++) {
//             int x = nums[i][i], y = nums[i][N - 1 - i];

//             if (primes[x]) {
//                 ans = Math.max(ans, x);
//             }

//             if (primes[y]) {
//                 ans = Math.max(ans, y);
//             }
//         }

//         return (int) ans;
//     }

//     private boolean[] sieveOfEratosthenes(int n) {
//         boolean[] prime = new boolean[n + 1];
//         for (int i = 0; i <= n; i++)
//             prime[i] = true;

//         for (int p = 2; p * p <= n; p++) {
//             if (prime[p]) {
//                 for (int i = p * p; i <= n; i += p)
//                     prime[i] = false;
//             }
//         }

//         return prime;
//     }
    
    
    public int diagonalPrime(int[][] nums) {
        int N = nums.length;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            int x = nums[i][i], y = nums[i][N - 1 - i];

            if (isPrime(x)) {
                ans = Math.max(ans, x);
            }

            if (isPrime(y)) {
                ans = Math.max(ans, y);
            }
        }

        return ans;
    }

    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}