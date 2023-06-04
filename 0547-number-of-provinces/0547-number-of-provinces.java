class Solution {
    int[] par, cnts;
    
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        
        this.init(N);
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(isConnected[i][j] == 1) {
                    this.union(i, j);
                }
            }
        }

        int ans = 0;

        for(int i=0; i<N; i++) {
            if(this.par[i] == i) ans++;
        }
        
        return ans;
    }
    
    private void init(int N) {
        this.par = new int[N+1];
        this.cnts = new int[N+1];

        for(int i=0; i<N; i++) {
            this.par[i] = i;
        }
    }
    
    private void union(int x, int y) {
        int xx = find(x), yy = find(y);
        
        if(this.cnts[xx] < this.cnts[yy]) {
            this.par[xx] = yy;
        } else if(this.cnts[xx] > this.cnts[yy]){
            this.par[yy] = xx;
        } else {
            this.par[yy] = xx;
            this.cnts[yy]++;            
        }
    }
    
    private int find(int x) {
        if(this.par[x] == x) return this.par[x];
        
        return this.par[x] = find(this.par[x]);
    }
}