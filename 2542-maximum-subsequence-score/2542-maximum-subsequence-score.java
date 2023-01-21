class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int N = nums1.length;
        int[][] zip = new int[N][2];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (a, b) -> a - b);

        for (int i = 0; i < N; i++) {
            zip[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(zip, (a, b) -> b[0] - a[0]);
        long ans = 0, sum = 0;

        for (var item : zip) {
            priorityQueue.add(item[1]);
            sum += item[1];

            if (priorityQueue.size() > k) {
                sum -= priorityQueue.poll();
            }

            if (priorityQueue.size() == k) {
                ans = Math.max(ans, sum * item[0]);
            }
        }
        return ans;
    }
}