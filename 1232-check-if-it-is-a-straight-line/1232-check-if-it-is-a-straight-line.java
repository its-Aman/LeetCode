class Solution {
    public boolean checkStraightLine(int[][] points) {
        int N = points.length;
        
        int delY = getDiff(points[1], points[0], 1);
        int delX = getDiff(points[1], points[0], 0);
            
        for(int i=2; i<N; i++) {
            if(delY*getDiff(points[i], points[0], 0) != delX*getDiff(points[i], points[0], 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private int getDiff(int[] x, int[] y, int idx) {
        return (x[idx]-y[idx]);
    }
}