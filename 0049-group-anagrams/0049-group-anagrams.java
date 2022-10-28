class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] hash = new int[26];

            for (char c : s.toCharArray())
                ++hash[c - 'a'];

            map.computeIfAbsent(Arrays.hashCode(hash), k -> new ArrayList<>()).add(s);
        }

        return List.copyOf(map.values());
    }
    
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<Integer, List<String>> map = new HashMap<>();

//         for(String s : strs){
//             char[] c = s.toCharArray();
//             Arrays.sort(c);
//             var hash = Arrays.hashCode(c);
//             map.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
//         }
        
//         return map.values().stream().toList();
//     }
}