/**
 Do not return anything, modify board in-place instead.

- Any live cell with fewer than two live neighbors dies as if caused by under-population.
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies, as if by over-population.
- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Help taken from below article: 
https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
*/

function gameOfLife(board: number[][]): void {
  const M = board.length,
        N = board[0].length;

  for(let i = 0; i < M; i++){
    for(let j = 0; j < N; j++){
      const neighbourCount = findNeighbours(i, j);      

      if(board[i][j] == 1 && neighbourCount >= 2 && neighbourCount <= 3)
          board[i][j] = 3;

      if(board[i][j] == 0 && neighbourCount == 3)
        board[i][j] = 2;
    }
  }

  for(let i = 0; i < M; i++)
    for(let j = 0; j < N; j++)
      board[i][j] >>= 1;


  function findNeighbours(i: number, j:number): number {
    const neighbours = [[-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]];
    let neighbourCount = 0;

    for(let [dx, dy] of neighbours){
      const x = dx + i, y = dy + j;
      if((x >= 0 && x < M) && (y >= 0 && y < N)){
        // console.log({x, y, b_x_y:board[x][y]})
        neighbourCount += board[x][y] & 1;
     }
    }

    // console.log({i, j, neighbourCount});
    return neighbourCount;
  }
};