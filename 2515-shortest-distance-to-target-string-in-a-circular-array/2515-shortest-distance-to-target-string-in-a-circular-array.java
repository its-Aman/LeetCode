class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int N = words.length;
        
        for(int i = 0; i < N; i++) {
            if(target.equals(words[i])) {
                int d = Math.abs(i - startIndex);
                ans = Math.min(ans, d);
                ans = Math.min(ans, N - d);
            }
        }
        
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        return ans;
    }
}