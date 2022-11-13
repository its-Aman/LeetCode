class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    int N;
    int[] maxPaths, parent, value;
    int INF = 1000000001;
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // System.out.println("*".repeat(50));
        N = amount.length;
        maxPaths = new int[N];
        parent = new int[N];
        value = amount;
        parent[0] = -1;

        buildGraph(edges);
        // System.out.println(g);
        
        findMaxPath(0);
        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(maxPaths));

        List<Integer> pathOfBob = new ArrayList<>();
        while(bob != -1) {
            pathOfBob.add(bob);
            bob = parent[bob];
        }
        
        Collections.reverse(pathOfBob);
        // System.out.println(pathOfBob);
        
        int ans = -INF,
            bobPathLength = pathOfBob.size();
        
        for(int idx = 0, costTillNow = 0; idx < bobPathLength; idx++) {
            boolean isAliceFirst = (idx < bobPathLength - 1 - idx),
                    isSameArrival = (idx == bobPathLength - 1 - idx);
            
            if(isAliceFirst)
                costTillNow += value[pathOfBob.get(idx)];

            if(isSameArrival)
                costTillNow += (value[pathOfBob.get(idx)] / 2);

            int nextIdx = idx + 1 < bobPathLength ? pathOfBob.get(idx + 1) : -1;
            ans = Math.max(ans, costTillNow + findBestExceptSpecificChild(pathOfBob.get(idx), nextIdx));
        }
        
        return ans;
    }
    
    private int findBestExceptSpecificChild(int root, int childToSkip) {
        int cost = -INF;
        int childCnt = 0;
        
        for(var nbr: g.getOrDefault(root, new ArrayList<>())) {
            if(nbr == parent[root])
                continue;
            
            childCnt++;
            
            if(nbr == childToSkip)
                continue;
            
            cost = Math.max(cost, maxPaths[nbr]);
        }
        
        if(childCnt == 0)
            return 0;
        
        // System.out.println(cost + " " + root + " " + childToSkip);
        return cost;
    }

    private void findMaxPath(int root) {
        maxPaths[root] = -INF;
        int childCnt = 0;
        
        for(var nbr: g.getOrDefault(root, new ArrayList<>())) {
            if(nbr == parent[root])
                continue;
            
            childCnt++;
            parent[nbr] = root;
            findMaxPath(nbr);
            maxPaths[root] = Math.max(maxPaths[root], maxPaths[nbr]);
        }
        
        if(childCnt == 0)
            maxPaths[root] = value[root];
        else
            maxPaths[root] += value[root];
    }
    
    private void buildGraph(int[][] edges) {
        for(var edge: edges) {
            g.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            g.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }    
}