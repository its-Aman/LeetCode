class Solution {
    public int mostBooked(int N, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] count = new int[N];

        PriorityQueue<int[]> engaged = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> unused = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            unused.offer(i);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            while (!engaged.isEmpty() && engaged.peek()[1] <= start)
                unused.offer(engaged.poll()[0]);

            if (unused.size() > 0) {
                int room = unused.poll();
                ++count[room];
                engaged.offer(new int[]{room, end});
            } else {
                int[] curr = engaged.poll();
                int room = curr[0], currEnd = curr[1];
                ++count[room];
                engaged.offer(new int[]{room, currEnd + end - start});
            }
        }

        int maxRoomId = 0;
        for (int i = 0; i < N; i++)
            if (count[i] > count[maxRoomId])
                maxRoomId = i;

        return maxRoomId;
    }

}