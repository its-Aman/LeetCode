class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrowNeeded = 1;
        
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int end = points[0][1];
        
        for(int i = 1; i < points.length; i++) {
            if(end >= points[i][0])
                continue;
        
            end = points[i][1];
            ++arrowNeeded;
        }
        
        return arrowNeeded;
    }
}