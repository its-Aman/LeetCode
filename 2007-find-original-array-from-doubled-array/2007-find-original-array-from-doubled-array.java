class Solution {
    public int[] findOriginalArray(int[] changed) {
        int N = changed.length;

        if (N % 2 == 1)
            return new int[0];

        TreeMap<Integer, Integer> counter = new TreeMap<>();
        int[] ans = new int[N / 2];
        int idx = 0;

        for (int num : changed)
            counter.put(num, counter.getOrDefault(num, 0) + 1);

        while (counter.size() > 0) {
            int smallest = counter.firstKey();
            counter.compute(smallest, (key, val) -> --val == 0 ? null : val);

            if (!counter.containsKey(smallest + smallest))
                return new int[0];

            counter.compute(smallest + smallest, (key, val) -> --val == 0 ? null : val);
            ans[idx++] = smallest;
        }

        return ans;
    }
}