class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (long g : gifts) {
            priorityQueue.offer(g);
        }

        while (k-- > 0) {
            priorityQueue.offer((long) Math.floor(Math.sqrt(priorityQueue.poll())));
        }

        while (!priorityQueue.isEmpty()) {
            ans += priorityQueue.poll();
        }

        return ans;
    }
}