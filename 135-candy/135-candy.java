class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] candies = new int[N];
        
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < N; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = 1 + candies[i - 1];
            }
        }
        
        int ans = candies[N - 1];

        for(int i = N - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(1 + candies[i], candies[i - 1]);
            }
            ans += candies[i - 1];
        }
        
        return ans;
    }
}