class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
      int dist = 0;
      int curr = 0;
      int node1Dist[] = new int[edges.length];
      int node2Dist[] = new int[edges.length];
      
      Arrays.fill(node1Dist, -1);
      Arrays.fill(node2Dist, -1);
      
      curr = node1;
      dist = 0;
      
      while(curr != -1 && node1Dist[curr] == -1) {
        node1Dist[curr] = dist;
        curr = edges[curr];
        dist += 1;
      }      
      
      curr = node2;
      dist = 0;
      
      while(curr != -1 && node2Dist[curr] == -1) {
        node2Dist[curr] = dist;
        curr = edges[curr];
        dist += 1;
      }      

      int sol = -1;
      int best = Integer.MAX_VALUE;
      
      for(int i = 0; i < edges.length; i++) {
        if(node1Dist[i] == -1 || node2Dist[i] == -1)
          continue;
        
        if(Math.max(node1Dist[i], node2Dist[i]) < best) {
          best = Math.max(node1Dist[i], node2Dist[i]);
          sol = i;
        }
      }
      
      return sol;
    }
}