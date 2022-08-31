class Solution {
    public int shortestSubarray(int[] nums, int K) {
        int N = nums.length, ans = N + 1;
        long[] prefix = new long[N + 1];

        for (int i = 0; i < N; i++)
            prefix[i + 1] = nums[i] + prefix[i];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= N; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= K)
                ans = Math.min(ans, i - deque.pollFirst());

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(i);
        }

        return ans > N ? -1 : ans;
    }
}