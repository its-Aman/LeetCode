class Solution {
   public int findMinArrowShots(int[][] points) {
        int arrowNeeded = 0;
        
        Arrays.parallelSort(points, Comparator.comparingInt(x -> x[1]));
        long end = Long.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (end < points[i][0]) {
                end = points[i][1];
                arrowNeeded++;
            }
        }
        
        return arrowNeeded;
    }
}