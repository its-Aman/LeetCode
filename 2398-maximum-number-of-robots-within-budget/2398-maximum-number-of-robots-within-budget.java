class Solution {
    public int maximumRobots(int[] cTms, int[] rCost, long Bgt) {
        int N = cTms.length, left = 0;
        long sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < N && left < N; right++) {
            sum += rCost[right];

            while (!deque.isEmpty() && cTms[deque.peekLast()] <= cTms[right])
                deque.pollLast();
            
            deque.offerLast(right);
            
            if (cTms[deque.peekFirst()] + (right - left + 1) * sum > Bgt) {
                if (deque.peekFirst() == left)
                    deque.pollFirst();
                sum -= rCost[left++];
            }
        }

        return N - left;
    }
}