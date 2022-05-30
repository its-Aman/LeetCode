/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumObstacles = function(grid) {
 const dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
       M = grid.length,
       N = grid[0].length,
       dp = Array.from(Array(M), () => Array(N).fill(Number.MAX_SAFE_INTEGER)),
       vis = Array.from(Array(M), () => Array(N).fill(false)),
       pq = new MinPriorityQueue();

  pq.enqueue([0, 0], grid[0][0]);
  
  while(!pq.isEmpty()){
    const { priority: c, element: [i, j] } = pq.dequeue();
    
    if(i == M - 1 && j == N - 1)
      return c
    
    for(let [dx, dy] of dirs){
      const x = i + dx,
            y = j + dy;
      
      if(x < 0 || y < 0 || x >= M || y >= N)
        continue;
      
      if(dp[x][y] > grid[x][y] + c){
        dp[x][y] = grid[x][y] + c;
        pq.enqueue([x, y], grid[x][y] + c);
      }
    }
  }
  
  return -1;
};