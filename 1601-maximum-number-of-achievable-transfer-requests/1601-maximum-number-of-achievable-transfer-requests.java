class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int ans = 0;
        int N = requests.length;

        for(int mask=0; mask<(1<<N); mask++) {
            int[] sink=new int[n];
            int pos = N-1;
            int bitCnt = Integer.bitCount(mask);
            if(bitCnt<=ans) continue;
            
            for(int curr=mask; curr>0; curr>>=1, pos--) {
                if((curr&1)==1) {
                    sink[requests[pos][0]]--;
                    sink[requests[pos][1]]++;
                }
            }
            
            boolean flag=true;
            
            for(int i=0; i<n; i++) {
                if(sink[i] != 0) {
                    flag=false;
                    break;
                }
            }

            if(flag) ans = bitCnt;
        }
        
        return ans;
    }
}