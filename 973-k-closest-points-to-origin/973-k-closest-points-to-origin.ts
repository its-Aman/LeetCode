function kClosest(points: number[][], K: number): number[][] {
  const N = points.length,
        mpq = new MaxPriorityQueue({priority: x => x}),
        ans = new Array(0);
  
  for(let i = 0; i < N; i++) {
    const dist = getDistance(points[i][0], points[i][1]);
    mpq.enqueue(i, dist);
    
    if(mpq.size() > K)
      mpq.dequeue();
  }

  while(mpq.size())
    ans.push(points[mpq.dequeue().element]);
  
  return ans;
  
  function getDistance(x: number, y: number): number {
    return ((x * x) + (y * y)) ^ 0.5;
  }
  
};