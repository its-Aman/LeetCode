class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            var hash = Arrays.hashCode(c);
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
        }
        
        return map.values().stream().toList();
    }
}