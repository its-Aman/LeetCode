class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n),
                bob = new UnionFind(n);
        int ans = 0;

        for(var e: edges) {
            if(e[0] == 3) {
                ans += (alice.union(e[2], e[1]) | bob.union(e[2], e[1]));
            }
        }
        
        for(var e: edges) {
            if(e[0] == 1) {
                ans += alice.union(e[2], e[1]);
            } else if(e[0] == 2) {
                ans += bob.union(e[2], e[1]);                
            }
        }
        
        if(alice.isConnected() && bob.isConnected()) {
            return edges.length - ans;
        }
        
        return -1;
    }
}

class UnionFind {
    int[] par, size;
    int n;
    
    public UnionFind(int N) {
        n = N;
        N++;
        par = new int[N];
        size = new int[N];
        
        while(N-- > 0) {
            par[N] = N;
            size[N] = 1;
        }
    }
    
    public int find(int x) {
        if(x == par[x]) {
            return x;
        }
        
        return par[x] = find(par[x]);
    }
    
    public int union(int x, int y) {
        int xx = find(x),
            yy = find(y);
        
        if(xx == yy) {
            return 0;
        }
        
        if(size[xx] > size[yy]) {
            par[yy] = xx;
        } else {
            par[xx] = yy;
            
            if (size[xx] == size[yy]) {
                size[yy]++;
            }
        }
        
        n--;
        return 1;
    }
    
    public boolean isConnected() {
        return n==1;
    }
}