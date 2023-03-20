class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int N = flowerbed.length;
                
        for(int i = 0; i < N; i++) {
            int pre = i - 1 < 0 ? 0 : flowerbed[i - 1];
            int post = i + 1 >= N ? 0 : flowerbed[i + 1];
            
            if((pre | flowerbed[i] | post) == 0) {
                n--;
                flowerbed[i++] = 1;
            }
            
            if(n == 0) {
                return true;
            }
        }
        
        return n <= 0;
    }
}