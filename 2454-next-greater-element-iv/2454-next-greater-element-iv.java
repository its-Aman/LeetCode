class Solution {
    public int[] secondGreaterElement(int[] A) {
        int N = A.length;
        List<List<Integer>> mid = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];

        Arrays.fill(ans, -1);

        for (int i = 0; i < N; i++)
            mid.add(new ArrayList<>());

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i])
                mid.get(i).add(stack.pop());

            stack.push(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>
                (Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < A.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < A[i])
                ans[pq.poll()[1]] = A[i];

            for (int j : mid.get(i))
                pq.offer(new int[]{A[j], j});
        }

        return ans;
    }
}