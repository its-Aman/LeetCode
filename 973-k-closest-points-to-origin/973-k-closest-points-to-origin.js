/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function(points, k) {
  
  const pq = new MaxPriorityQueue({priority: x => x}),
        getM = (x, y) => Math.sqrt(x**2 + y**2),
        ans = [];
  
  for(let [x, y] of points) {
    pq.enqueue([x, y], getM(x, y));
    
    if(pq.size() == k + 1)
      pq.dequeue();
  }
  
  
  while(!pq.isEmpty())
    ans.push(pq.dequeue().element)
  
  return ans;
};