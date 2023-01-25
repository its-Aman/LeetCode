class Solution {
    public int closestMeetingNode(int[] edges, int n1, int n2) {
        int N = edges.length,
            ans = -1, 
            max = Integer.MAX_VALUE;

        int[] d1 = calcDepth(edges, n1);
        int[] d2 = calcDepth(edges, n2);
        
        for(int i = 0; i < N; i++) {
            if(d1[i] == -1 || d2[i] == -1) {
                continue;
            }
            
            if(max > Math.max(d1[i], d2[i])) {
                max = Math.max(d1[i], d2[i]);
                ans = i;
            }
        }
        
        return ans;
    }
    
    private int[] calcDepth(int[] edges, int node) {
        int[] dist = new int[edges.length];
        int curr = node, depth = 0;

        Arrays.fill(dist, -1);
        
        while(curr != -1 && dist[curr] == -1) {
            dist[curr] = depth;
            curr = edges[curr];
            depth += 1;
        }
        
        return dist;
    }
}