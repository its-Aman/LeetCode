class Solution {
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