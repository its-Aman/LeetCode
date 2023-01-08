class Solution {
    public int maxPoints(int[][] points) {
        int N = points.length;
        
        if(N <= 2) {
            return N;
        }
        
        int ans = 2;
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                int currMax = 2;
                
                for(int k = 0; k < N; k++) {
                    if(k != i && k != j && onSameLine(points, i, j, k)) {
                        currMax++;
                    }
                }
                
                ans = Math.max(ans, currMax);
            }
        }
        
        return ans;
    }
    
    private boolean onSameLine(int[][] points, int i, int j, int k) {
        int[] p1 = points[i],
                p2 = points[j],
                p3 = points[k];
        
        return (p2[1] - p1[1]) * (p3[0] - p1[0]) == (p3[1] - p1[1]) * (p2[0] - p1[0]);
    }
}