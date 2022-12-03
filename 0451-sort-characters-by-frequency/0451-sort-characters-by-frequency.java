class Solution {
    public String frequencySort(String s) {

        int[] cnt = new int[128];
        s = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());

        for (char c : s.toCharArray())
            cnt[c]++;

        return Arrays.stream(s.split("")).sorted(Comparator.comparingInt(f -> -cnt[f.charAt(0)])).collect(Collectors.joining());

        
//         Map<Character, Integer> freq = new HashMap<>();

//         for (char c : s.toCharArray())
//             freq.put(c, freq.getOrDefault(c, 0) + 1);

//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(f -> -f.getValue()));
//         pq.addAll(freq.entrySet());
        
//         StringBuilder sb = new StringBuilder();

//         while (!pq.isEmpty()) {
//             var curr = pq.poll();
//             sb.append(curr.getKey().toString().repeat(curr.getValue()));
//         }

//         return sb.toString();
    }
}