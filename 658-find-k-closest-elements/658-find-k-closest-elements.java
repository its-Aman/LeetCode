class Solution {
    public List<Integer> findClosestElements(int[] A, int K, int X) {
        int N = A.length, L = 0, R = N - K;
        
        while(L < R) {
            int M = L + (R - L) / 2;
            
            if(X - A[M] > A[M + K] - X)
                L = M + 1;
            else
                R = M;
        }
        
        List<Integer> ans = new ArrayList<>();

        for(int i = L; i < L + K; i++)
            ans.add(A[i]);
        
        return ans;
    }
}