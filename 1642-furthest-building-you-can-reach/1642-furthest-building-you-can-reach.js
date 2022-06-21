/**
 * @param {number[]} heights
 * @param {number} bricks
 * @param {number} ladders
 * @return {number}
 */

// https://leetcode.com/problems/furthest-building-you-can-reach/discuss/918374/Basic-Priority-Queue-Single-Pass-or-Code-with-Comments-or-Corner-Cases
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