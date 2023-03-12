class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t[1]));
        int ans = 0, N = tasks.length;
        boolean[] visited = new boolean[2002];

        for (int i = 0; i < N; i++) {
            int completed = 0, start = tasks[i][0], end = tasks[i][1], duration = tasks[i][2];

            for (int j = start; j <= end; j++) {
                if (visited[j]) {
                    completed++;
                }
            }

            while (completed < duration) {
                if (!visited[end]) {
                    ans++;
                    completed++;
                    visited[end] = true;
                }
                end--;
            }
        }

        return ans;
    }
}