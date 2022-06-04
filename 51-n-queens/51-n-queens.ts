// https://leetcode.com/problems/n-queens/discuss/810358/C%2B%2B-4ms-Heavily-Commented-Clean-Solution-or-Fast-and-Easy-or-Explanation

function solveNQueens(N: number): string[][] {
  const board = Array.from(Array(N), () => Array(N).fill('.')),
        ans = [];
  
  helper(0);
  
  return ans;
  
  function helper(row: number): void {
    if(row == N){
      ans.push(board.slice(0).map(c => c.join('')));
      return;
    }
    
    for(let i = 0; i < N; i++) {
      if(check(row, i)){
        board[row][i] = 'Q';
        helper(row + 1);
        board[row][i] = '.';        
      }
    }  
  }
  
  function check(row: number, col: number): boolean {

    // check col
    for(let i = row; i >= 0; --i)
      if(board[i][col] == 'Q')
        return false;
    
    // left diag '\'
    for(let i = row, j = col; i >= 0 && j >= 0; --i, --j)
      if(board[i][j] == 'Q')
        return false;

    // right diag '/'
    for(let i = row, j = col; i >= 0 && j < N; --i, ++j)
      if(board[i][j] == 'Q')
        return false;

    return true;    
  }
};