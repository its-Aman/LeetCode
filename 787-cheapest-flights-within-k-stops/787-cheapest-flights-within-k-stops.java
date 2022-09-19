class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] f : flights)
            graph.computeIfAbsent(f[0], k -> new ArrayList<>()).add(new int[]{f[1], f[2], 0});

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        int[] minDepth = new int[n];

        Arrays.fill(minDepth, -1);
        priorityQueue.add(new int[]{src, 0, 0});

        while (!priorityQueue.isEmpty()) {
            int[] currNode = priorityQueue.poll();
            int node = currNode[0],
                    dist = currNode[1],
                    depth = currNode[2];

            if (node == dst)
                return dist;

            if (depth > K || minDepth[node] != -1 && minDepth[node] < depth)
                continue;

            minDepth[node] = depth;

            for (int[] child : graph.getOrDefault(node, new ArrayList<>())) {
                int childNode = child[0],
                        childDist = child[1];
                priorityQueue.add(new int[]{childNode, childDist + dist, depth + 1});
            }
        }

        return -1;
    }
}