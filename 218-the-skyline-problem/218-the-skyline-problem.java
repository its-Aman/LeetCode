class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList();
        int N = buildings.length;
        int[][] heights = new int[N * 2][2]; // array is fast to use, hence avoiding List

        for (int i = 0; i < 2 * N; i += 2) {
            int[] building = buildings[i / 2];
            heights[i] = new int[]{building[0], -building[2]}; // starting point
            heights[i + 1] = new int[]{building[1], building[2]}; // ending point
        }

        Arrays.sort(heights, (h1, h2) -> {
            if (h1[0] != h2[0])
                return h1[0] - h2[0]; // if different starting points, sort based on the difference. i.e. bigger comes first
            return h1[1] - h2[1]; // same starting points, sort based on height
        });

        // taking treemap to reduce the remove operation complexity to O(log(n))
        TreeMap<Integer, Integer> q = new TreeMap<>();
        q.put(0, 1); // default case, means we've 1 building of 0 height.
        int prevMaxHeight = 0;

        for (int[] height : heights) {
            if (height[1] < 0)  // negative indicating starting point of the building
                q.compute(-height[1], (k, v) -> v == null ? 1 : v + 1); // we add it to the set by incrementing the count of same height building
            else
                q.compute(height[1], (k, v) -> v == 1 ? null : v - 1); // we remove current building since this is marking it's end, hence we're decreasing it's count

            int currMaxHeight = q.lastKey(); // this get's the max height building till now.

            if (currMaxHeight != prevMaxHeight) {
                ans.add(Arrays.asList(height[0], currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }

        return ans;
    }
}