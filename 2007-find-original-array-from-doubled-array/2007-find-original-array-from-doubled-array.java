class Solution {
    
    public int[] findOriginalArray(int[] changed) {
        int N = changed.length;

        if (N % 2 == 1)
            return new int[0];

        int max = Integer.MIN_VALUE;

        for (int num : changed)
            max = Math.max(max, num);

        if (max % 2 == 1)
            return new int[0];

        int[] counter = new int[max + 1];
        int[] ans = new int[N / 2];

        for (int num : changed)
            ++counter[num];

        if (counter[0] % 2 == 1)
            return new int[0];

        int idx = counter[0] / 2;

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0)
                continue;

            if (i + i > max || counter[i] > counter[i + i])
                return new int[0];

            counter[i + i] -= counter[i];
            while (counter[i]-- > 0)
                ans[idx++] = i;
        }

        return ans;
    }

    public int[] findOriginalArray_2(int[] changed) {
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