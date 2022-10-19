class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        
        for(String word: words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        
        List<String> ans = new ArrayList<>();
        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>((p1, p2) -> (p2.getKey() == p1.getKey()) ? p1.getValue().compareTo(p2.getValue()) : (p2.getKey() - p1.getKey()));

        for(var key: freq.keySet())
            pq.offer(new Pair(freq.get(key), key));
            
        k = pq.size() - k;

        while(!pq.isEmpty()) {
            if(pq.size() > k)
                ans.add(pq.poll().getValue());    
            else
                pq.poll();
        }
        
        return ans;
    }
}