class SummaryRanges {
    TreeMap<Integer, Integer> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int value) {
        int left = value, right = value;

        var leftLeft = treeMap.floorEntry(value);
        if (leftLeft != null) {
            if (leftLeft.getValue() >= value) {
                return;
            }

            if (leftLeft.getValue() == value - 1) {
                left = leftLeft.getKey();
            }
        }

        var rightRight = treeMap.higherEntry(value);
        if (rightRight != null && rightRight.getKey() == value + 1) {
            treeMap.remove(right + 1);
            right = rightRight.getValue();
        }

        treeMap.put(left, right);
    }

    public int[][] getIntervals() {
        int[][] ans = new int[treeMap.size()][2];
        int i = 0;

        for (var e : treeMap.entrySet()) {
            ans[i++] = new int[]{e.getKey(), e.getValue()};
        }

        return ans;
    }
}


class SummaryRanges2 {
    boolean[] map;
    int min, max;

    public SummaryRanges2() {
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