class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;

        int N = costs.length,
                i = 0, j = N - 1;

        PriorityQueue<Integer> front = new PriorityQueue<>(),
                back = new PriorityQueue<>();

        while (k-- > 0) {
            while (front.size() < candidates && i <= j)
                front.offer(costs[i++]);

            while (back.size() < candidates && j >= i)
                back.offer(costs[j--]);

            int f = !front.isEmpty() ? front.peek() : Integer.MAX_VALUE;
            int b = !back.isEmpty() ? back.peek() : Integer.MAX_VALUE;

            if (f <= b) {
                ans += f;
                front.poll();
            } else {
                ans += b;
                back.poll();
            }
        }

        return ans;
    }
}