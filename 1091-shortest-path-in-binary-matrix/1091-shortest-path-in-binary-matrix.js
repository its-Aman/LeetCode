/**
 * @param {number[][]} grid
 * @return {number}
 */

// https://www.youtube.com/watch?v=CABaqOkWbgQ

var shortestPathBinaryMatrix = function(grid) {
  const N = grid.length;

  if(grid[0][0] || grid[N - 1][N - 1])
    return -1;
  
  const q = new Queue(),
        dir = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [1, -1], [-1, 1], [-1, -1]];
  
  q.enqueue([0, 0, 1]);
  grid[0][0] = 1;
  
  while(!q.isEmpty()) {
    let size = q.size();
    
    while(size > 0){
      const [i, j, dist] = q.dequeue();
      
      if(i == N - 1 && j == N - 1)
        return dist;

      for(let [start, end] of dir){
        let r = start + i,
            l = end + j;
        
        if(r >= 0 && l >= 0 && r < N && l < N && !grid[r][l]){
          q.enqueue([r, l, dist + 1]);
          grid[r][l] = 1;          
        }
      }
      size--;
    }
  }
  
  return -1;
};