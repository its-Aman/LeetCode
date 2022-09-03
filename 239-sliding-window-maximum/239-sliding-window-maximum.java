class Solution {
    public int[] maxSlidingWindow(int[] nums, int K) {
        Deque<Integer> deque = new ArrayDeque<>();
        int N = nums.length;
        int[] ans = new int[N - K + 1];

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            deque.offerLast(i);

            if (deque.peekFirst() + K == i)
                deque.pollFirst();

            if (i >= K - 1 )
                ans[i - K + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}