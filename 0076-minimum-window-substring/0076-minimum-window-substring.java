class Solution {
    public String minWindow(String s, String t) {
        int M = s.length(), 
            N = t.length(),
            desired = 0;
        int[] sMap = new int[1 << 6],
                tMap = new int[1 << 6];
        
        String ans = "";
        
        for(var c: t.toCharArray()) {
            if(tMap[c-'A'] == 0)
                ++desired;
            ++tMap[c-'A'];
        }
        
        int l = 0, r = 0, formed = 0;
        
        while(r < M) {
            int currIdx = s.charAt(r)-'A';
            ++sMap[currIdx];
            
            if(sMap[currIdx] == tMap[currIdx])
                ++formed; 
            
            while(l <= r && formed == desired) {
                int len = ans.length();
                currIdx = s.charAt(l) - 'A';
                
                
                if(len == 0 || (r - l + 1) < len)
                    ans = s.substring(l, r + 1);
                
                --sMap[currIdx];
                
                if(sMap[currIdx] < tMap[currIdx])
                    --formed;
                
                ++l;
            }
            
            ++r;
        }
        
        return ans;
    }
}