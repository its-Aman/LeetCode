function totalNQueens(N: number): number {
  const board = Array.from(Array(N), () => Array(N).fill('.'));
  let ans = 0;
  
  chess(0);
  
  return ans;
  
  function chess(row: number): void {
    if(row == N){
      ans++;
      return;
    }
    
    if(row > N)
      return 

  for(let col = 0; col < N; col++){
    if(check(row, col)){
      board[row][col] = 'Q';
      chess(row + 1);
      board[row][col] = '.';
    }
  }
}
  
  
  function check(r: number, c: number){
    // check column
    for(let row = 0; row <= r; row++)
      if(board[row][c] == 'Q')
        return false;

    // check left diag
    for(let row = r, col = c; row >= 0 && col >= 0; row--, col--)
      if(board[row][col] == 'Q')
        return false;

    // check right diag
    for(let row = r, col = c; row >= 0 && col < N; row--, col++)
      if(board[row][col] == 'Q')
        return false;

    return true;
  }
};