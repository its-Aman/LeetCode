class Solution {

    // https://www.youtube.com/watch?v=oNI0rf2P9gE
    public int findTheCity(int N, int[][] edges, int K) {
        int[][] dist = new int[N][N];

        for(var r: dist)
            Arrays.fill(r, 10001);

        for (var e : edges)
            dist[e[0]][e[1]] = dist[e[1]][e[0]] = e[2];
        
        for(int i = 0; i < N; i++)
            dist[i][i] = 0;
        
        for(int k = 0; k < N; k++)
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int ans = -1;
        int min = N;

        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++)
                if(dist[i][j] <= K)
                    ++count;
            
            if(count <= min) {
                ans = i;
                min = count;
            }
        }

        return ans;
    }
    
    
    
    
    Map<Integer, List<int[]>> g = new HashMap<>();

    public int findTheCity_Failed_DFS(int N, int[][] edges, int k) {
        for (var e : edges) {
            g.computeIfAbsent(e[0], _k -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            g.computeIfAbsent(e[1], _k -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }

        int[] cities = new int[N];
        Set<Integer> vis = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (g.containsKey(i)) {
                vis.add(i);
                dfs(k, i, vis);
                cities[i] = vis.size();
                vis.clear();
            }
        }

        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (min >= cities[i]) {
                ans = Math.max(ans, i);
                min = cities[i];
            }
        }

        return ans;
    }

    private int dfs(int dist, int curr, Set<Integer> visited) {
        int ans = 0;
        List<int[]> nbrs = g.get(curr);

        if (dist <= 0 || nbrs.size() == 0)
            return ans;
        
        for (var nbr : nbrs) {
            if (nbr[1] <= dist && !visited.contains(nbr[0])) {
                visited.add(nbr[0]);
                ans += 1 + dfs(dist - nbr[1], nbr[0], visited);
            }
        }

        return ans;
    }
}