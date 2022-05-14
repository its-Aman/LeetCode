/**
 * @param {number[][]} times
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var networkDelayTime = function(times, n, k) {
  const dist = new Array(n + 1).fill(Number.MAX_SAFE_INTEGER),
        mpq = new MinPriorityQueue(),
        map = new Map();
  
  // console.log(mpq.enqueue.toString())
  
  for(let [source, dest, time] of times){
    if(!map.has(source))
      map.set(source, []);
    
    map.get(source).push([dest, time]);
  }
  
  dist[k] = 0;
  mpq.enqueue(k, dist[k])
  
  while(!mpq.isEmpty()) {    
    // console.log(mpq.toArray())
    const {element: prev_node, priority: prev_dist} = mpq.front();
    mpq.dequeue();
    
    if(!map.has(prev_node))
      continue;
    
    for(let [next_node, next_dest] of map.get(prev_node))
      if(dist[next_node] > dist[prev_node] + next_dest){
        dist[next_node] = dist[prev_node] + next_dest;
        mpq.enqueue(next_node, dist[next_node]);
      }
  }
   
  // console.log(dist)
  let min = Number.MIN_SAFE_INTEGER,
      [first, ...remaining] = dist;
  
  for(let resultDist of remaining){
    
    if(resultDist == Number.MAX_SAFE_INTEGER)
      return -1;
    min = Math.max(min, resultDist);
  }
  
  return min;
};