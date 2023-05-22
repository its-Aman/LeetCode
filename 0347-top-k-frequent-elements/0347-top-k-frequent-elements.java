class Solution {
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (var key : map.keySet()) {
            pq.offer(new int[]{map.get(key), key});
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];

        while (k-- > 0) {
            ans[pq.size() - 1] = pq.poll()[1];
        }

        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] fq = new int[20001];

        for (int num : nums) {
            fq[num + 10000]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < fq.length; i++) {
            if (fq[i] > 0) pq.offer(new int[]{fq[i], i-10000});

            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];

        while (k-- > 0) {
            ans[pq.size() - 1] = pq.poll()[1];
        }

        return ans;
    }
}