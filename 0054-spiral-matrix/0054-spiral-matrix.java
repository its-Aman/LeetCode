class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int R=matrix.length, C=matrix[0].length;
        int T=0, Rt=C-1, B=R-1, L=0;

        while(T<=B && L<=Rt) {
            // top row
            for(int c=L; c<=Rt; c++) {
                ans.add(matrix[T][c]);
            }
            T++;
            
            if(T>B) break;

            // right col
            for(int r=T; r<=B; r++) {
                ans.add(matrix[r][Rt]);
            }
            Rt--;
            
            if(L>Rt) break;

            // bottom row
            for(int c=Rt; c>=L; c--) {
                ans.add(matrix[B][c]);
            }
            B--;
            
            if(T>B) break;
            
            // left col
            for(int r=B; r>=T; r--) {
                ans.add(matrix[r][L]);
            }
            L++;
        }
        
        return ans;
    }
}