class Solution {
    public int totalFruit(int[] tree) {
        // track last two fruits seen
        int fruit1 = -1;
        int fruit2 = -1;
        int fruit1Cnt = 0;
        int currBasketSize = 0;
        int maxBucketSize = 0;

        for (int fruit : tree) {
            if (fruit == fruit1 || fruit == fruit2)
                currBasketSize++;
            else
                currBasketSize = fruit1Cnt + 1; // last fruit + new fruit

            if (fruit == fruit1)
                fruit1Cnt++;
            else
                fruit1Cnt = 1;

            if (fruit != fruit1) {
                fruit2 = fruit1;
                fruit1 = fruit;
            }

            maxBucketSize = Math.max(maxBucketSize, currBasketSize);
        }

        return maxBucketSize;
    }
}