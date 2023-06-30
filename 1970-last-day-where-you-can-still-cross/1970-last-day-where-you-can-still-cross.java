class Solution2 {
    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int LAND=0, WATER=1, NONE=-1;

    public int latestDayToCross(int R, int C, int[][] cells) {
        int l=1, r=R*C;
        while(l<r) {
            int m = r-((r-l)/2);
            if(canCross(R,C,cells,m))l=m;
            else r=m-1;
        }
        
        return l;
    }
    
    private boolean canCross(int R, int C, int[][] cells, int day) {
        int N = cells.length;
        int[][] island = new int[R][C];
        Queue<int[]> q = new LinkedList<>();
        
        while(day-->0) island[cells[day][0]-1][cells[day][1]-1]=WATER;

        for(int c=0; c<C; c++) {
            if(island[0][c]==LAND) {
                q.offer(new int[] {0, c});
                island[0][c]=NONE;
            }
        }
        
        while(!q.isEmpty()) {
            var curr = q.poll();
            int r=curr[0], c=curr[1];
            if(r == R-1) return true;
            
            for(var dir: dirs) {
                int rr = r+dir[0], cc=c+dir[1];
                if(rr>=0 && cc>=0 && rr<R && cc<C && island[rr][cc] == LAND) {
                    island[rr][cc] = NONE;
                    q.offer(new int[] {rr, cc});
                }
            }
        }
        
        return false;
    }
    
}

class UF {
    int[] par, size;
    
    public UF(int n) {
        par = new int[n];
        size = new int[n];
        
        while(n-->0) {
            par[n]=n;
            size[n]=1;
        }
    }
    
    public int find(int x) {
        return (x != par[x]) ? par[x] = find(par[x]) : par[x];
    }
    
    public void union(int x, int y) {
        int xx = find(x), yy = find(y);
        if(xx == yy) return;
        
        if(size[xx] < size[yy]) {
            par[xx] = yy;            
        } else {
            par[yy] = xx;
            size[yy] += size[xx];
        }
    }
}

class Solution {
    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int latestDayToCross(int R, int C, int[][] cells) {
        UF uf = new UF(R*C+2);
        int[][] grid = new int[R][C];
        
        for(int i=cells.length-1; i>=0; i--) {
            int r = cells[i][0]-1, c = cells[i][1]-1;
            grid[r][c] = 1;
            int x = r*C+c+1;
            for(var dir: dirs) {
                int rr = r+dir[0], cc = c+dir[1];
                int y = rr*C+cc+1;
                
                if(rr>=0 && rr<R && cc>=0 && cc<C && grid[rr][cc] == 1) uf.union(x,y);
            }
            
            if(r==0) uf.union(0,x);
            if(r==R-1) uf.union(R*C+1,x);
            
            if(uf.find(0) == uf.find(R*C+1)) return i;
        }
        
        return -1;
    }
}