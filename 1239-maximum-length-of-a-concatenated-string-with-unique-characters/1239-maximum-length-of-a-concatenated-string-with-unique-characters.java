class Solution {
        public int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int ans = 0;

        for (String s : arr) {
            int mask = 0, dup = 0;

            for (char c : s.toCharArray()) {
                int bit = 1 << (c - 'a');
                dup |= mask & bit;
                mask |= bit;
            }

            if (dup > 0) continue;

            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & mask) > 0) continue;

                dp.add(dp.get(i) | mask);
                ans = Math.max(ans, Integer.bitCount(dp.get(i) | mask));
            }

        }
        return ans;
    }

    
// //    int max = 0;

//     public int maxLength(List<String> arr) {
// //        dfs(arr, 0, "");
//         int N = arr.size();
//         int[] map = new int[N];

//         for (int i = 0; i < N; i++)
//             map[i] = makeMask(arr.get(i));

// //        return max;
//         return dfs(map, 0, 0);
//     }

//     private int dfs(int[] map, int idx, int mask) {
//         int ans = 0;

//         if (idx == map.length) {
//             while (mask > 0) {
//                 ans++;
//                 mask = mask & (mask - 1);
//             }
//             return ans;
//         }

//         if (map[idx] != 0 && ((mask & map[idx]) == 0))
//             ans = dfs(map, idx + 1, mask | map[idx]);

//         ans = Math.max(ans, dfs(map, idx + 1, mask));

//         return ans;
//     }

//     private int makeMask(String s) {
//         int[] m = new int[26];

//         for (char c : s.toCharArray())
//             if (++m[c - 'a'] == 2) return 0;

//         int mask = 0;

//         for (int i = 0; i < 26; i++)
//             mask |= (m[i] << i);

//         return mask;
//     }

// //    private void dfs(List<String> arr, int start, String str) {
// //        if (!isUnique(str))
// //            return;
// //
// //        max = Math.max(max, str.length());
// //
// //        for (int i = 0; i < arr.size(); i++)
// //            dfs(arr, i + 1, str + arr.get(i));
// //    }
// //
// //    private boolean isUnique(String str) {
// //        Set<Character> set = new HashSet<>();
// //
// //        for (char c : str.toCharArray())
// //            if (set.contains(c))
// //                return false;
// //            else
// //                set.add(c);
// //
// //        return true;
// //    }

}