class Solution {
    int[] par, cnt;
    
    public int numSimilarGroups(String[] strs) {
        int N = strs.length;
        
        init(N);
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        
        return countParants();
    }
    
    private void init(int N) {
        par = new int[N];
        cnt = new int[N];
        
        while(N-- > 0) {
            par[N] = N;
            cnt[N] = 1;
        }
    }
    
    private int find(int x) {
        if(x != par[x]) {
            par[x] = find(par[x]);
        }
        
        return par[x];
    }
    
    private void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);

        if(cnt[xx] > cnt[yy]) {
            par[yy] = xx;
        } else {
            par[xx] = yy;
            cnt[xx]++;
        }
    }
    
    private int countParants() {
        int ans = 0;
        
        for(int i=0; i<par.length; i++) {
            if(i == par[i]) {
                ans++;
            }
        }
        
        return ans;
    }
    
    private boolean isSimilar(String s1, String s2) {
        for(int i=0, cnt=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt += 1;
                if(cnt > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}