class SummaryRanges {
    boolean[] map;
    int min, max;

    public SummaryRanges() {
        map = new boolean[10_002];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void addNum(int value) {
        map[value] = true;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    public int[][] getIntervals() {
        // System.out.println(min + "-" + max);
        List<int[]> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if(!map[i]) {
                continue;
            }

            int start = i, end = i;

            while (end < max && map[end + 1]) {
                end++;
            }

            list.add(new int[]{start, end});
            i = end + 1;
        }

        return list.toArray(new int[list.size()][2]);
    }
}


/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */