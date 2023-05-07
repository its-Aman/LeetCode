class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int N = queries.length;
        int[] ans = new int[N];
        int[] colors = new int[n+2];
        
        for(int i=0, cnt=0; i<N; i++) {
            int idx = queries[i][0]+1, color = queries[i][1];

            if(colors[idx] > 0) {
                cnt -= (colors[idx-1] == colors[idx] ? 1 : 0) + (colors[idx+1] == colors[idx] ? 1 : 0);
            }
            
            colors[idx] = color;
            cnt += (colors[idx-1] == colors[idx] ? 1 : 0) + (colors[idx+1] == colors[idx] ? 1 : 0);
            ans[i] = cnt;
        }
        
        return ans;
    }
}