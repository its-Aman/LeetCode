class UnionFind {
    int N;
    int[] par;
    
    public UnionFind() {
        par = new int[26];

        for(int i = 0; i < 26; i++) {
            par[i] = i;
        }
    }
    
    public void union(int x, int y) {
        int xx = find(x),
            yy = find(y);
        
        if(xx < yy) {
            par[yy] = xx;
        } else {
            par[xx] = yy;
        }
    }
    
    public int find(int x) {
        if(x == par[x]) {
            return x;
        } else {
            return par[x] = find(par[x]);
        }
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int N = s1.length();
        UnionFind uf = new UnionFind();
        
        for(int i = 0; i < N; i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c: baseStr.toCharArray()) {
            sb.append((char)('a' + uf.find(c -'a')));
        }
        
        return sb.toString();
    }
}