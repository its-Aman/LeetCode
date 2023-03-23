class UnionFind {
    int[] rank, parent;
    
    UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        
        while(n-- > 0) {
            parent[n] = n;
        }
    }
    
    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
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
            parent[yy] = xx;
        } else {
            parent[yy] = xx;
            rank[xx]++;
        }
    }
}

class Solution {
    
    public int makeConnected(int N, int[][] connections) {
        if(connections.length < N - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(N + 1);
        int cableRequired = N - 1;

        for(int[] conn: connections) {
            if(uf.find(conn[0]) != uf.find(conn[1])) {
                uf.union(conn[0], conn[1]);
                cableRequired--;
            }
        }
        
        return cableRequired;
    }
}