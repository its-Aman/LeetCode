class Solution {

    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        
        for(String s: words)
            ++count[s.charAt(0)-'a'][s.charAt(1)-'a'];
        
        int ans = 0;
        boolean mid = false;
        
        for(int row = 0; row < 26; row++) {
            if(count[row][row] % 2 == 0) {
                ans += count[row][row];
            } else {
                ans += count[row][row] - 1;
                mid = true;
            }
            
            for(int col = row + 1; col < 26; col++)
                ans += 2 * Math.min(count[row][col], count[col][row]);
        }
        
        if(mid) ans++;
        
        return 2 * ans;
    }
    
    public int longestPalindrome2(String[] words) {
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