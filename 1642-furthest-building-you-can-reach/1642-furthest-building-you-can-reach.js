/**
 * @param {number[]} heights
 * @param {number} bricks
 * @param {number} ladders
 * @return {number}
 */
// https://leetcode.com/problems/furthest-building-you-can-reach/discuss/1177210/Easy-Solution-w-Clear-Explanation-and-Comments-or-Priority-Queue-and-Multiset

var furthestBuilding2 = function(heights, bricks, ladders) {
  const N = heights.length,
        pq = new MaxPriorityQueue({priority: x => x});
  let i = 0;
  
  while(i < N - 1 && pq.size() < ladders) {
    const jumpHeight = heights[i + 1] - heights[i];
    if(jumpHeight > 0)
      pq.enqueue(jumpHeight);
    i++;
  }
  
  while(i < N - 1) {
    const jumpHeight = heights[i + 1] - heights[i];
    
    if(jumpHeight > 0) {
      
      if(pq.size() && pq.front().element < jumpHeight) {
        bricks -= pq.dequeue().element;
        pq.enqueue(jumpHeight);
      } else {
        bricks -= jumpHeight;
      }
    }
    
    if(bricks < 0)
      return i;
    
    i++;
  }
  
  return i;
};

var furthestBuilding = function(heights, bricks, ladders) {
  const N = heights.length,
        pq = new MaxPriorityQueue({priority: x => x});
  let i = 0,
      totalBricksUsed = 0;
  
  for(; i < N - 1; i++) {
    if(heights[i] >= heights[i + 1])
      continue;
    
    const diff = heights[i + 1] - heights[i];
    
    if(totalBricksUsed + diff <= bricks) {
      totalBricksUsed += diff;
      pq.enqueue(diff);
    } else if(ladders > 0) {
      if(!pq.isEmpty() && pq.front().element > diff) {
        totalBricksUsed = totalBricksUsed - pq.dequeue().element + diff;
        pq.enqueue(diff);
      }
      ladders--;
    } else {
      break;
    }
  }
  
  return i;
}