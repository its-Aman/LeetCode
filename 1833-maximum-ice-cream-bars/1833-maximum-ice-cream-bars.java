class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int M = 0;
        int ans = 0;
        
        for(int cost: costs) {
            M = Math.max(M, cost);
        }
        
        int[] freq = new int[M + 1];
        
        for(int cost: costs) {
            freq[cost]++;
        }
        
        for(int i = 1; i <= M; i++) {
            if(freq[i] == 0) {
                continue;
            }

            if(coins < i) {
                break;
            }
            
            int cnt = Math.min(freq[i], coins / i);
            coins -= i * cnt;
            ans += cnt;
        }
        
        return ans;
    }    
    
    public int maxIceCream2(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        
        while(i < costs.length && costs[i] <= coins) {
            coins -= costs[i];            
            i++;
        }
                
        return i;
    }
}