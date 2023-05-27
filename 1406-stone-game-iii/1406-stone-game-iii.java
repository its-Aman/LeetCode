class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int first=0, second=0, third=0, total=0;

        for(int i=N-1; i>=0; i--) {
            total += stoneValue[i];
            int curr = Math.max(total-first, Math.max(total-second, total-third));
            third=second;
            second=first;
            first=curr;
        }
        
        total-=first;
        
        if(first > total) return "Alice";
        if(first < total) return "Bob";
        
        return "Tie";
    }
}