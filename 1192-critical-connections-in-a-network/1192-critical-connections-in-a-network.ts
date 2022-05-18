function criticalConnections(N: number, connections: number[][]): number[][] {
  const low: number[] = new Array(N).fill(0), 
        visited: boolean[] = new Array(N).fill(false),
        ans: number[][] = [],
        g = new Map<number, number[]>();
  
  for (let[a,b] of connections) {
    if (!g.has(a))
        g.set(a, []);
    g.get(a).push(b);
    
    if (!g.has(b))
        g.set(b, []);
    g.get(b).push(a);
  }

    tarjanAlgo(g, -1, 0, 0, visited, ans, low);
    return ans;
};

function tarjanAlgo(graph: Map<number, number[]>, parentId: number, nodeId: number, id: number, visited: boolean[], ans: number[][], low: number[]){
  visited[nodeId] = true;
  low[nodeId] = ++id;
  let currentNodeLowest = low[nodeId];
  
  for(let neighbourId of graph.get(nodeId)){
    if(parentId == neighbourId)
      continue;
    
    if(!visited[neighbourId])
      tarjanAlgo(graph, nodeId, neighbourId, id, visited, ans, low);
    
    low[nodeId] = Math.min(low[nodeId], low[neighbourId]);
    
    if(currentNodeLowest < low[neighbourId])
      ans.push([nodeId, neighbourId]);
  }
}