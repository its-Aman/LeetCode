class Solution {
  public void dfs(int[][] grid, int i, int j, int minutes) {
    if(
      (i < 0 || i >= grid.length)
      || (j < 0 || j >= grid[0].length)
      || (grid[i][j] == 0)
      || (grid[i][j] > 1 && grid[i][j] < minutes)
    )
      return;
    
    grid[i][j] = minutes;
    
    dfs(grid, i + 1, j, 1 + minutes);
    dfs(grid, i - 1, j, 1 + minutes);
    dfs(grid, i, j + 1, 1 + minutes);
    dfs(grid, i, j - 1, 1 + minutes);
  }
  
  public int orangesRotting(int[][] grid) {
    
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == 2) {
          dfs(grid, i, j, 2);
        }
      }
    }
      
    int minutes = 2;

    for(int[] rows: grid) {
      for(int cell: rows) {
        if(cell == 1){
          return -1;
        } else {
          minutes = Math.max(minutes, cell);
        }
      }
    }

    return minutes - 2;
  }
}