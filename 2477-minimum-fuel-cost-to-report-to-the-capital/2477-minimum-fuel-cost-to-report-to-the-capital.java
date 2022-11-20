class Solution {
    long ans = 0;
    List<List<Integer>> list = new ArrayList<>();

    public long minimumFuelCost(int[][] roads, int seats) {
        int N = roads.length + 1;

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        dfs(0, -1, seats);
        return ans;
    }

    private int dfs(int node, int parent, double seats) {
        int size = 1;
        for (int child : list.get(node)) {
            if (child == parent)
                continue;
            size += dfs(child, node, seats);
        }
        
        if (node != 0)
            ans += (long) Math.ceil(size / seats);
        return size;
    }
}