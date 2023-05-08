class Solution {
    public int diagonalSum(int[][] mat) {
        int M=mat.length, N=mat[0].length;
        int ans=0;
        
        for(int i=0; i<mat.length; i++) {
            int j=N-1-i;
            ans += mat[i][i];
            ans += mat[i][j];
            if(i==j) ans -= mat[i][i];
        }
        
        return ans;
    }
}
/*
[
    [7,3,1,9],
    [3,4,6,9],
    [6,9,6,6],
    [9,5,8,5]
]


*/