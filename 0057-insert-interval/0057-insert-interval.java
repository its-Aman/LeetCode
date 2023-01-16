class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length, i = 0;
        List<int[]> result = new LinkedList<>();
        
        while (i < N && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        
        while (i < N && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[] {
                    Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1])
                };
            i++;
        }

        result.add(newInterval);

        while (i < N) {
            result.add(intervals[i++]); 
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}