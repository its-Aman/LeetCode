class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        
        for(var l: edges) {
            in[l.get(1)]++;
        }
        
        List<Integer> ans = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            if(in[i] == 0) ans.add(i);
        }
        
        return ans;
    }
}