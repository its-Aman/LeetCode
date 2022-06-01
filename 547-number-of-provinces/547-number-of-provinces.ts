function findCircleNum(isConnected: number[][]): number {
  const N = isConnected.length;
  const g = buildGraph(isConnected);
  let id = 0,
      sccCount = 0;
  
  const UNVISITED = -1,
        ids = new Array(N).fill(UNVISITED),
        low = new Array(N).fill(0),
        onStack = new Array(N).fill(false),
        stack = [];
  
  for(let i = 0; i < N; i++){
    if(ids[i] == UNVISITED)
      dfs(i);
  }
  
  return sccCount;


  function dfs(at: number){
    stack.push(at);
    onStack[at] = true;
    id++;
    ids[at] = low[at] = id;
    
    for(let to of g.get(at)){
      if(ids[to] == UNVISITED)
        dfs(to);

      if(onStack[to])
        low[at] = Math.min(low[at], low[to]);
    }
    
    if(ids[at] == low[at]){
      for(let node = stack.pop(); ; node = stack.pop()){
        onStack[node] = false;
        low[node] = ids[at];
        if(node == at)
          break;
      }
      sccCount++;
    }
  }

  function buildGraph(matrix: number[][]): Map<number, number[]>{
    const N = matrix.length,
          g = new Map<number, number[]>();

    for(let i = 0; i < N; i++){
      for(let j = 0; j < N; j++){
        if(matrix[i][j])
          if(g.has(i))
            g.get(i).push(j);
          else
            g.set(i, [j]);
      }
    }

    return g;
  }

}