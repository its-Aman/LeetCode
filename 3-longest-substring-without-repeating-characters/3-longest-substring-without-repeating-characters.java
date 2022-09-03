class Solution {
    public int lengthOfLongestSubstring(String S) {
        int ans = 0, N = S.length();
        Set<Character> seen = new HashSet<>();
        
        for(int left = 0, right = 0; right < N; ++right) {
            while(seen.contains(S.charAt(right))) {
                ans = Math.max(ans, seen.size());
                seen.remove(S.charAt(left++));
            }

            seen.add(S.charAt(right));
        }
        
        return Math.max(ans, seen.size());
    }
}