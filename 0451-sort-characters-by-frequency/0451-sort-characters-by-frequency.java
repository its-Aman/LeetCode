class Solution {
    public String frequencySort(String s) {        
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(f -> -f.getValue()));
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        pq.addAll(freq.entrySet());
        
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            char ch = curr.getKey();
            int cnt = curr.getValue();

            while(cnt-- > 0)
                sb.append(ch);
        }

        return sb.toString();
    }
}