class Solution {
    public int longestPalindrome(String[] words) {
        int N = words.length;
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        boolean mid = false;
        
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0) + 1);            

        for(String key: map.keySet()) {
            int freq = map.get(key);
                        
            if(key.charAt(1) == key.charAt(0)) {
                if(freq%2==1) {
                    ans += freq-1;
                    mid=true;
                } else {
                    ans += freq;
                }
            } else if(key.charAt(1) > key.charAt(0)) {
                String rev = "" + key.charAt(1) + key.charAt(0);
                ans += Math.min(map.getOrDefault(rev, 0), freq)*2;
            }
        }
        
        if(mid) ans++;
        
        return ans * 2;
    }
}