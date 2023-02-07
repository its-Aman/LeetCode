class Solution {
    public int totalFruit(int[] fruits) {
        int f1 = -1, f2 = -1;
        int nf1 = 0, currBucketSize = 0, maxBucketSize = 0;
        
        for(int f: fruits) {
            if(f1 == f || f2 == f) {
                currBucketSize += 1;
            } else {
                currBucketSize = nf1 + 1;
            }
            
            if(f1 == f) {
                nf1 += 1;
            } else {
                nf1 = 1;
            }
            
            if(f != f1) {
                f2 = f1;
                f1 = f;
            }
            
            maxBucketSize = Math.max(maxBucketSize, currBucketSize);
        }
        
        return maxBucketSize;
    }
}