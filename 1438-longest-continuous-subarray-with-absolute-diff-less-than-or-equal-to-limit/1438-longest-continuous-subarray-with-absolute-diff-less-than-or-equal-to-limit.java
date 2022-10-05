class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0;
        int N = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (j = 0; j < N; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit)
                map.computeIfPresent(nums[i++], (k, v) -> v == 1 ? null : v - 1);
        }

        return j - i;

//         Deque<Integer> min = new LinkedList<>(), max = new LinkedList<>();
//         int N = nums.length, l = 0, ans = Integer.MIN_VALUE;

//         for (int r = 0; r < N; r++) {
//             while (!min.isEmpty() && min.peekLast() > nums[r])
//                 min.pollLast();
//             min.offerLast(nums[r]);

//             while (!max.isEmpty() && max.peekLast() < nums[r])
//                 max.pollLast();
//             max.offerLast(nums[r]);

//             if (max.peekFirst() - min.peekFirst() > limit) {
//                 if (max.peekFirst() == nums[l]) max.pollFirst();
//                 if (min.peekFirst() == nums[l]) min.pollFirst();
//                 ++l;
//             }
//             ans = Math.max(ans, r - l + 1);
//         }

//         return ans;
    }
}