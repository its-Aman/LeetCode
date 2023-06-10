class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l=1, r=maxSum;
        
        while(l<r) {
            int m=(l+r+1)/2;
            if(getSum(index, m, n) <= maxSum) l=m;
            else r=m-1;
        }
        
        return l;
    }
    
    private long getSum(int idx, int val, int n) {
        long cnt=0;
        
        if(val>idx) cnt += (long)(val+val-idx)*(idx+1)/2;
        else cnt += (long)(val+1)*val/2 + (idx-val+1);
        
        if(val>=n-idx) cnt += (long)(val+val-n+1+idx)*(n-idx)/2;
        else cnt += (long)(val+1)*val/2 + (n-idx-val);

        return cnt-val;
    }
    
}