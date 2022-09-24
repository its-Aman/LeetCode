class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int totalIntervals = intervals.length;
        int nonOverlappingIntervalCount = 0;
        
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int currIntervalStart = intervals[i][0];
            int currIntervalEnd = intervals[i][1];
            
            if (currIntervalStart >= end) {
                end = currIntervalEnd;
                ++nonOverlappingIntervalCount;
            }
        }

        return totalIntervals - nonOverlappingIntervalCount;
    }
}