class Solution {
    public int sumOfMultiples(int n) {
        return divisible(n,3)+divisible(n,5)+divisible(n,7)-
            divisible(n,15)-divisible(n,21)-divisible(n,35)+divisible(n,105);
    }
    
    private int divisible(int n, int d) {
        int cnt = n/d;
        return d*cnt*(cnt+1)/2;
    }
    
    public int sumOfMultiples2(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
                ans += n;
            }
            n--;
        }

        return ans;
        
    }
}