class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0) return -1;
        if(arr1.length == 1) return 0;
        
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        if(arr2 != null) {
            for(int a2: arr2) treeSet.add(a2);
        }
        
        int N = arr1.length;
        int[][] dp = new int[N+1][N+1];
        
        for(int i=0; i<N+1; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        dp[0][0] = Integer.MIN_VALUE;
        
        for(int j=1; j<N+1; j++) {
            for(int i=0; i<=j; i++) {
                if(arr1[j-1]>dp[i][j-1]){
                    dp[i][j]=arr1[j-1];
                }
                
                Integer higher = i>0 && dp[i-1][j-1]<Integer.MAX_VALUE?treeSet.higher(dp[i-1][j-1]):null;
                
                if(higher!=null) {
                    dp[i][j]=Math.min(dp[i][j], higher);
                }
                
                if(j==N && dp[i][j]!=Integer.MAX_VALUE) return i;
            }
        }
        
        return -1;
    }
}