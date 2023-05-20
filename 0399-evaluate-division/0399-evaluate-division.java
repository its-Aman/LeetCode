class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var g = buildGraph(equations, values);
        double[] ans = new double[queries.size()];
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<queries.size(); i++) {
            set.clear();
            ans[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), set, g);
        }
        
        return ans;
    }
    
    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(start)) return -1.0;
        
        if(graph.get(start).containsKey(end)) return graph.get(start).get(end);
        
        visited.add(start);
        
        for(var nbrKey: graph.get(start).keySet()) {
            if(visited.contains(nbrKey)) continue;
            
            double productWeight = getPathWeight(nbrKey, end, visited, graph);
            
            if(productWeight != -1.0) return graph.get(start).get(nbrKey) * productWeight;
        }
        
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        
        for(int i=0; i<equations.size(); i++) {
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            
            g.computeIfAbsent(u, k -> new HashMap<>()).put(v, values[i]);
            g.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1/values[i]);
        }
        
        return g;
    }
}