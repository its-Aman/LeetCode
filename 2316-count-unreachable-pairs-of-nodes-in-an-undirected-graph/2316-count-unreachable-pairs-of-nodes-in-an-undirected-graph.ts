// https://www.youtube.com/watch?v=6GF-lXohHC4

function countPairs(N: number, edges: number[][]): number {
  let i = 0
  const parent = Array.from(new Array(N), () => i++),
        counts = new Array<number>(N).fill(0);
  // let total = (N * (N - 1)) / 2;
  let total = 0;
    
  for(let [s, t] of edges)
    uunion(s, t);
  

  for(let i = 0; i < N; i++) {
    const ui = ufind(i);
    counts[ui] += 1;
  }
  
  // console.log({parent, counts})
  
  for(let val of counts)
    total += val * (N - val);

  return total / 2;
  
  function ufind(x: number): number {
    if(parent[x] != x)
      parent[x] = ufind(parent[x]);
    return parent[x];
  }
  
  function uunion(s: number, t: number): void {
    const us = ufind(s),
          ut = ufind(t);
  
    parent[us] = ut;      
  }
}

function countPairs_old(N: number, edges: number[][]): number {
  const g = new Map<number, number[]>(),
        visited = new Array<boolean>(N).fill(false),
        parents = new Array<number>(N);
  
  let currentlyConnected = ((N*(N-1)) >>> 1);
  buildGraph();
  
  for(let i = 0; i < N; i++)
    parents[i] = i;
  
  for(let [s, t] of edges) {
    let curr = s;
    while(parents[s] != curr)
      curr = parents[s]
  }
  
  console.log(g, currentlyConnected, parents)
  
  for(let i = 0; i < N; i++)
    dfs(i);
  
  return currentlyConnected;
  
  function dfs(v) {
    if(!g.get(v).length || visited[v])
      return;

    visited[v] = true;
    currentlyConnected--;
    for(let i of g.get(v))
      dfs(i);
    visited[v] = false;
  }

  function buildGraph() { 
    for(let i = 0; i < N;  i++)
      g.set(i, []);

    for(let [s, t] of edges)
      g.get(s).push(t);

    return g;
  }
}