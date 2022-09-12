class Solution {
    final double EPSILON = 0.000001;
    Random random = new Random();
    List<Box[]> list = new ArrayList<>();

    public Solution(int[] w) {
        if (w == null || w.length <= 0)
            return;

        double sum = 0;

        for (int wt : w)
            sum += wt;

        double avg = sum / w.length;

        List<Box> largerList = new ArrayList<>();
        List<Box> smallerList = new ArrayList<>();

        for (int i = 0; i < w.length; i++) {
            Box box = new Box(i, w[i]);

            if (box.val >= avg - EPSILON)
                largerList.add(box);
            else
                smallerList.add(box);
        }

        while (smallerList.size() > 0) {
            Box smaller = smallerList.remove(smallerList.size() - 1);
            Box larger = largerList.get(largerList.size() - 1);

            list.add(new Box[]{smaller, new Box(larger.i, avg - smaller.val)});

            larger.val -= avg - smaller.val;

            if (larger.val < avg - EPSILON) {
                largerList.remove(largerList.size() - 1);
                if (larger.val > EPSILON)
                    smallerList.add(larger);
            }
        }

        for (Box box : largerList)
            list.add(new Box[]{box, null});

    }

    public int pickIndex() {
        if (list.size() == 0)
            return -1;

        int idx = random.nextInt(list.size());
        Box[] pair = list.get(idx);

        if (pair[1] == null)
            return pair[0].i;

        double randomData = random.nextDouble(pair[0].val + pair[1].val);

        if (randomData < pair[0].val)
            return pair[0].i;

        return pair[1].i;
    }

    class Box {
        int i;
        double val;

        public Box(int i, double val) {
            this.i = i;
            this.val = val;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */