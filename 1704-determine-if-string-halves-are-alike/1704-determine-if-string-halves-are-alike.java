class Solution {
    public boolean halvesAreAlike(String s) {
        int N = s.length();
        int x = 0, y = 0;
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        for(int i = 0; i < N; i++) {
            if(set.contains(s.charAt(i)))
                if(i < N/2) {
                   x++;
                } else {
                    y++;
                }
        }
        
        return x == y;
    }
}