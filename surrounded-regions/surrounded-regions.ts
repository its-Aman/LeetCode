/**
 Do not return anything, modify board in-place instead.
 */
function solve(board: string[][]): void {
  // first step would be to identify the region
  
  // check if the identified region is 4-directionally surrounded.
  // exclude the region that is on the border OR 
  // any one part of the region is on the border.
  
  /***************************************************************/
  //   
  // NeetCode gave an intuition that we need to capture everything 
  // except the unsourrounded ones.
  //
  // https://www.youtube.com/watch?v=9z2BunfoZ5Y
  /***************************************************************/

  const M = board.length,
        N = board[0].length,
        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]];

  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
      if(board[i][j] == 'O' && ([0, M-1].includes(i) || [0, N-1].includes(j)))
        capture(i, j);


  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
      if(board[i][j] == 'O')
        board[i][j] = 'X';

  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
      if(board[i][j] == 'T')
        board[i][j] = 'O';

  function capture(r: number, c: number): void {
    if(r < 0 || c < 0 || r == M || c == N || board[r][c] !== 'O')
      return;
    
    board[r][c] = 'T';
    for(let [dx, dy] of dirs)
      capture(r + dx, c + dy);
  }

};