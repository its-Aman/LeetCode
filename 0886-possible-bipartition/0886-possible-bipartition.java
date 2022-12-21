class DSU {
    int[] parent, rank;
    
    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        
        for(int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        int _parent = x;

        while(parent[_parent] != _parent) {
            _parent = parent[_parent];
        }

        while(x != _parent) {
            int next = this.parent[x];
            this.parent[x] = _parent;
            x = next;
        }

        return _parent;
    }

    public void union(int x, int y) {
        int xx = find(x),
            yy = find(y);
        
        if(xx == yy) {
            return;
        } else if(this.rank[xx] < this.rank[yy]) {
            this.parent[xx] = yy;
        } else if(this.rank[xx] > this.rank[yy]) {
            this.parent[yy] = xx;
        } else {
            this.parent[yy] = xx;
            this.rank[xx] += 1;
        }
    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // return possibleBipartition_DSU(n, dislikes);
        return possibleBipartition_BFS_DFS(n, dislikes);
    }
    
    public boolean possibleBipartition_DSU(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        DSU dsu = new DSU(n + 1);
        
        for(var edge: dislikes) {
            g.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            g.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        
        for(int node = 1; node <= n; node++) {
                
            if(!g.containsKey(node)) {
                continue;
            }
            
            for(int next: g.get(node)) {
                if(dsu.find(node) == dsu.find(next))
                    return false;
                dsu.union(g.get(node).get(0), next);
            }
        }
        
        return true;    
    }

    public boolean possibleBipartition_BFS_DFS(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] color = new int[n + 1];
        
        for(var edge: dislikes) {
            g.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            g.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        Arrays.fill(color, -1);
        
        for(int i = 1; i <= n; i++) {
            if(color[i] == -1) {
                // if(!dfs(i, 0, g, color)) {
                //     return false;
                // }
                if(!bfs(i, g, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(int source, Map<Integer, List<Integer>> g, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        color[source] = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
                
            if(!g.containsKey(node)) {
                continue;
            }
            
            for(int next: g.get(node)) {
                if(color[next] == color[node]) {
                    return false;
                }
                    
                if(color[next] == -1) {
                    color[next] = 1 - color[node];
                    q.offer(next);
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int node, int nodeColor, Map<Integer, List<Integer>> g, int[] color) {
        color[node] = nodeColor;

        if(!g.containsKey(node))
            return true;
        
        for(int next: g.get(node)) {
            if(color[next] == color[node]) {
                return false;
            }
            
            if(color[next] == -1) {
                if(!dfs(next, 1 - nodeColor, g, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }    
}