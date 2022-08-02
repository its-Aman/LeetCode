class Solution {
    public int kthSmallest(int[][] matrix, int K) {
        int N = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[N - 1][N - 1];
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            
			for (int i = 0; i < N; i++) {
				int ub = this.upperBound(matrix[i], mid);
				if(ub == 0)
					break;
				cnt += ub;
			}
            
            if(cnt < K)
                lo = 1 + mid;
            else
                hi = mid;
        }
        
        return lo;
    }
    
    private int upperBound(int[] arr, int K) {
        int lo = 0;
        int hi = arr.length;
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] <= K)
                lo = 1 + mid;
            else
                hi = mid;
        }
        
        return lo;
    }
}