class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int b1 : basket1) {
            count.put(b1, count.getOrDefault(b1, 0) + 1);
        }

        for (int b2 : basket2) {
            count.put(b2, count.getOrDefault(b2, 0) - 1);
        }

        List<Integer> swaps = new ArrayList<>();
        long ans = 0, small = count.firstKey();

        for (int key : count.keySet()) {
            int val = count.get(key);
            if (val % 2 > 0) {
                return -1;
            }

            for (int i = 0; i < Math.abs(val) / 2; i++) {
                swaps.add(key);
            }
        }

        for (int i = 0; i < swaps.size() / 2; i++) {
            ans += Math.min(swaps.get(i), small * 2);
        }
        
        return ans;
    }
}