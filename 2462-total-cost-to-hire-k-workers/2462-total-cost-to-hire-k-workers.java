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

            if (!front.isEmpty() && !back.isEmpty())
                if (front.peek() <= back.peek())
                    ans += front.poll();
                else
                    ans += back.poll();
            else if (back.isEmpty())
                ans += front.poll();
            else if (front.isEmpty())
                ans += back.poll();

        }

        return ans;
    }
}