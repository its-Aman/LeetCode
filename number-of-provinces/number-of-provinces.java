class DisjointSet {
    
    int[] root;
    int[] rank;
    
    public DisjointSet(int N) {
        this.root = new int[N];
        this.rank = new int[N];
        
        for(int i = 0; i < N; i++) {
            this.root[i] = i;
            this.rank[i] = 1;
        }
    }
    
    public int find(int x) {
        int temp = x;
        
        while(temp != this.root[temp]) {
            temp = this.root[temp];
        }
        
        while(x != temp) {
            int next = this.root[x];
            this.root[x] = temp;
            x = next;
        }
        
        return temp;
    }
    
    public void union(int x, int y) {
        int xx = this.find(x);
        int yy = this.find(y);
        
        if(xx == yy) return;
        
        if(this.rank[xx] > this.rank[yy]) {
            this.root[yy] = xx;
        } else if(this.rank[xx] > this.rank[yy]) {
            this.root[xx] = yy;
        } else {
            this.root[xx] = yy;
            this.rank[yy] += 1;
        }
    }
    
    public boolean isConnected(int x, int y) {
        return this.find(x) == this.find(y);
    }
}

class Solution {
    
    public int findCircleNum(int[][] matrix) {
        int N = matrix.length;
    
        Set<Integer> set = new HashSet();
        
        DisjointSet djs = new DisjointSet(N);

        for(int i = 0; i < N; i++) {
            
            for(int j = i; j < N; j++) {
                
                if(matrix[i][j] == 1)
                    djs.union(i, j);
                
            }
            
        }
        
        for(int i = 0; i < N; i++) {
            set.add(djs.find(i));
        }
        
        return set.size();
    }
}