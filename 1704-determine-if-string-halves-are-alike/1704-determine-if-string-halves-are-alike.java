class Solution {
    public boolean halvesAreAlike(String s) {
        int N = s.length();
        int x = 0, y = 0;
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < N; i++) {
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||ch[i]=='A'||ch[i]=='E'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U')                
                if(i < N/2) {
                   x++;
                } else {
                    y++;
                }
        }
        
        return x == y;
    }
}