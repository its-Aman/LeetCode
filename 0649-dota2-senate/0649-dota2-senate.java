class Solution {
    public String predictPartyVictory(String senate) {
        int N = senate.length();
        Queue<Integer> d = new LinkedList<>(), r = new LinkedList<>();
        
        for(int i=0; i<N; i++) {
            if(senate.charAt(i) == 'D') {
                d.offer(i);
            } else {
                r.offer(i);
            }
        }
        
        while(!d.isEmpty() && !r.isEmpty()) {
            int dx = d.poll(), rx = r.poll();
            
            if(dx<rx) {
                d.offer(dx+N);
            } else {
                r.offer(rx+N);
            }
        }
        
        if(d.isEmpty()) return "Radiant";
        
        return "Dire";
    }
}