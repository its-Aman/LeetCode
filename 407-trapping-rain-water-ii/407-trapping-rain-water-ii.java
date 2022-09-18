class Solution {
    public int trapRainWater(int[][] heightMap) {
        int M = heightMap.length, N = heightMap[0].length;
        int ans = 0;

        if (M == 0 || N == 0 || M < 3 || N < 3)
            return ans;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(ht -> ht[0]));

        for (int i = 0; i < M; i++) {
            heap.offer(new int[]{heightMap[i][0], i, 0});
            heap.offer(new int[]{heightMap[i][N - 1], i, N - 1});
            heightMap[i][0] = heightMap[i][N - 1] = -1;
        }

        for (int j = 1; j < N - 1; j++) {
            heap.offer(new int[]{heightMap[0][j], 0, j});
            heap.offer(new int[]{heightMap[M - 1][j], M - 1, j});
            heightMap[0][j] = heightMap[M - 1][j] = -1;
        }

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int height = curr[0],
                    x = curr[1],
                    y = curr[2];

            for (int[] dir : dirs) {
                int i = x + dir[0],
                        j = y + dir[1];

                if ((i < 0 || i >= M) || (j < 0 || j >= N) || heightMap[i][j] == -1)
                    continue;

                ans += Math.max(0, height - heightMap[i][j]);
                heap.offer(new int[]{Math.max(height, heightMap[i][j]), i, j});
                heightMap[i][j] = -1;
            }
        }

        return ans;
    }
}