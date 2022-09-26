class Solution {
    public boolean equationsPossible(String[] equations) {
        int N = equations.length;
        UnionFind uf = new UnionFind(26);
        
        for(int i = 0; i < N; i++) {
            int x = equations[i].charAt(0) - 'a';
            int y = equations[i].charAt(3) - 'a';
            char cond = equations[i].charAt(1);
            
            if(cond == '=')
                uf.union(x, y);
        }

        for(int i = 0; i < N; i++) {
            int x = equations[i].charAt(0) - 'a';
            int y = equations[i].charAt(3) - 'a';
            char cond = equations[i].charAt(1);
            
            if(cond == '!' && uf.isEqual(x, y)) 
                return false;
        }
        
        return true;
    }
    
    static class UnionFind {
        int[] parents;
        int[] rank;
        
        UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            
            while(n-- > 0) {
                parents[n] = n;
                rank[n] = 1;
            }
        }
        
        public boolean isEqual(int x, int y) {
            return find(x) == find(y);
        }
        
        public void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            
            if(xx == yy)
                return;
            
            if(rank[xx] > rank[yy]) {
                parents[yy] = xx;
            } else if(rank[yy] > rank[xx]) {
                parents[xx] = yy;
            } else {
                parents[yy] = xx;
                ++rank[yy];
            }
        }
        
        public int find(int x) {
            if(parents[x] == x)
                return x;
            return parents[x] = find(parents[x]);
        }
    }
    
}