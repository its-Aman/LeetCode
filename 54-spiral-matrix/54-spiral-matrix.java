class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        List<Integer> list = new ArrayList<>();
                
        int startRow = 0;
        int endRow = R - 1;
        
        int startCol = C - 1;
        int endCol = 0;
        
        while(true) {
            
            for(int c = endCol; c <= startCol; c++)
                list.add(matrix[startRow][c]);
            startRow += 1;

            if(list.size() == R * C)
                break;
            
            for(int r = startRow ; r <= endRow; r++) 
                list.add(matrix[r][startCol]);
            startCol -= 1;                

            if(list.size() == R * C)
                break;

            for(int c = startCol; c >= endCol; c--)
                list.add(matrix[endRow][c]);
            endRow -= 1;

            if(list.size() == R * C)
                break;

            for(int r = endRow; r >= startRow; r--) 
                list.add(matrix[r][endCol]);
            endCol += 1;

            if(list.size() == R * C)
                break;

            if(startRow > endRow && startCol < endCol)
                break;
        }
                
        return list;
    }
}