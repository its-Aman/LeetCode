class UnionFind {
    int[] rank, parent;
    
    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        
        while(n-- > 0) {
            parent[n] = n;
        }
    }
    
    public void union(int x, int y) {
        int xx = find(x),
            yy = find(y);

        if(xx == yy) {
            return;
        }
        
        if(rank[xx] > rank[yy]) {
            parent[yy] = xx;
        } else if(rank[yy] > rank[xx]) {
            parent[xx] = yy;
        } else {
            parent[xx] = yy;
            rank[yy]++;
        }
        
    }
    
    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        var uf = new UnionFind(n+1);
        
        for(int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        
        long ans = 0;
        long[] cnts = new long[n];
        
        for(int i = 0; i < n; i++) {
            cnts[uf.find(i)]++;    
        }
        
        for(long cnt: cnts) {
            ans += cnt * (n - cnt);
        }
        
        return ans / 2;
    }
}