class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int N = obstacles.length;
        int[] ans = new int[N],
            lis = new int[N];
        
        for(int i=0, L=0; i<N; i++) {
            int idx = binarySearchRight(lis, obstacles[i], L);
            if(idx == L) L++;
            lis[idx] = obstacles[i];
            ans[i] = idx + 1;
        }
        
        return ans;
    }
    
    private int binarySearchRight(int[] A, int K, int R) {
        if(R == 0) return 0;

        int L = 0;
        
        while(L < R) {
            int M = L + (R-L)/2;
            if(A[M] <= K) L = M + 1;
            else R = M;
        }
        
        return L;
    }
}