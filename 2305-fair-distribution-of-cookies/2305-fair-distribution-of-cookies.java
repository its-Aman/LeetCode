class Solution {
    int ans = Integer.MAX_VALUE;
    
    public int distributeCookies(int[] cookies, int k) {
        dfs(cookies, new int[k], 0, 0);
        return ans;
    }
    
    private void dfs(int[] cookies, int[] child, int idx, int max) {
        if(idx >= cookies.length) {
            ans = Math.min(ans, max);
            return;
        };
        
        int c = cookies[idx];
        
        for(int i=0; i<child.length; i++) {
            child[i] += c;
            dfs(cookies, child, idx+1, Math.max(max, child[i]));
            child[i] -= c;
        }
    }
}

class Solution2 {
    public int distributeCookies(int[] cookies, int k) {
        return dfs(0, new int[k], cookies, k, k);
    }
    
    private int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCnt) {
        if(cookies.length-i < zeroCnt) return Integer.MAX_VALUE;

        if(cookies.length == i) {
            int unfairness = Integer.MIN_VALUE;
            for(int val: distribute) unfairness = Math.max(val, unfairness);
            return unfairness;
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int j=0; j<k; j++) {
            zeroCnt -= distribute[j]==0 ? 1 : 0;
            distribute[j] += cookies[i];
            
            ans = Math.min(ans, dfs(i+1, distribute, cookies, k, zeroCnt));
            
            distribute[j] -= cookies[i];
            zeroCnt += distribute[j]==0 ? 1 : 0;
        }
        
        return ans;
    }
}