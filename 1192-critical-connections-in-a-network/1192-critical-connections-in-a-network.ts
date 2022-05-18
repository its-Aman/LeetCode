function criticalConnections(N: number, connections: number[][]): number[][] {
  const low: number[] = new Array(N).fill(0), 
        visited: boolean[] = new Array(N).fill(false),
        ans: number[][] = [],
        g = new Map<number, number[]>();
  let id = 0;
  
  for (let[a,b] of connections) {
    if (!g.has(a))
        g.set(a, []);
    g.get(a).push(b);
    
    if (!g.has(b))
        g.set(b, []);
    g.get(b).push(a);
  }

    tarjanAlgo(-1, 0);
    return ans;

  function tarjanAlgo(parentId: number, nodeId: number){
    visited[nodeId] = true;
    low[nodeId] = ++id;
    let currentNodeLowest = low[nodeId];

    for(let neighbourId of g.get(nodeId)){
      if(parentId == neighbourId)
        continue;

      if(!visited[neighbourId])
        tarjanAlgo(nodeId, neighbourId);

      low[nodeId] = Math.min(low[nodeId], low[neighbourId]);

      if(currentNodeLowest < low[neighbourId])
        ans.push([nodeId, neighbourId]);
    }
  }
}