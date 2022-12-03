class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(f -> -f.getValue()));

        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char f : freq.keySet())
            pq.offer(new Pair<>(f, freq.get(f)));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            var curr = pq.poll();
            sb.append(curr.getKey().toString().repeat(curr.getValue()));
        }

        return sb.toString();
    }
}