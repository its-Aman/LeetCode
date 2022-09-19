class Solution {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        return findCheapestPrice_Dijkastra(n, flights, src, dst, k);
        return findCheapestPrice_BellmanFord(n, flights, src, dst, k);
    }

    public static int findCheapestPrice_BellmanFord(int n, int[][] flights, int source, int target, int k) {
        int[] destination = new int[n];
        Arrays.fill(destination, Integer.MAX_VALUE);
        destination[source] = 0;

        for (int i = 0; i <= k; i++) {
            int[] oldDestination = destination.clone();
            boolean ans = true;

            for (int[] f : flights) {
                int src = f[0], dest = f[1], cost = f[2];
                if (oldDestination[src] < Integer.MAX_VALUE && destination[src] + cost < destination[dest]) {
                    destination[dest] = oldDestination[src] + cost;
                    ans = false;
                }
            }

            if (ans)
                break;
        }


        return destination[target] == Integer.MAX_VALUE ? -1 : destination[target];
    }

    public int findCheapestPrice_Dijkastra(int n, int[][] flights, int src, int dst, int K) {
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