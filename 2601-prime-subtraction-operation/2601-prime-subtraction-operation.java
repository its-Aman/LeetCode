class Solution {
    private int[] seive_algo(int N) {
        boolean[] isPrimes = new boolean[N];
        int[] primes = new int[N];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = isPrimes[1] = false;

        for (int i = 2; i * i < N; i++) {
            for (int j = 2 * i; j < N; j += i) {
                isPrimes[j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (isPrimes[i]) {
                primes[i] = i;
            }
        }

        return primes;
    }

    public boolean primeSubOperation(int[] nums) {
        int N = nums.length;
        int[] primes = seive_algo(1005);

        int prev = nums[N - 1];
        boolean flag = false;

        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] < prev) {
                prev = nums[i];
                continue;
            }
            
            flag = true;

            for (int sub = 0; sub < primes.length && primes[sub] < nums[i]; sub++) {
                if (nums[i] - primes[sub] < prev) {
                    prev = nums[i] - primes[sub];
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                break;
            }
        }

        return !flag;
    }
}