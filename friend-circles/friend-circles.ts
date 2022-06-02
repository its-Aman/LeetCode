// https://www.youtube.com/watch?v=wUgWX0nc4NY

function findCircleNum(isConnected: number[][]): number {
  // return tarjanAlgo(isConnected);
  
  const N = isConnected.length;
  const uf = new UnionFind(N);
  
  for(let i = 0; i < N; i++)
    for(let j = i + 1; j < N; j++)
      if(isConnected[i][j])
        uf.union(i, j);

  return uf.count();
}

// https://leetcode.com/problems/number-of-provinces/discuss/101336/Java-solution-Union-Find

class UnionFind {
  private _count: number;
  private parent: number[];
  private rank: number[];

  public constructor(size: number) {
    this._count = size;
    this.parent = new Array(size);
    this.rank = new Array(size).fill(1);
    
    for(let i = 0; i < size; i++)
      this.parent[i] = i;
    
  }

  public find(p: number): number {
    while(p != this.parent[p]){
      this.parent[p] = this.parent[this.parent[p]];
      p = this.parent[p];
    }
    
    return p;
  }

  public union(p: number, q: number): void{
    const rootP = this.find(p),
          rootQ = this.find(q);
    
    if(rootP == rootQ)
      return;
    
    if(this.rank[rootQ] > this.rank[rootP]){
      this.parent[rootP] = rootQ;
    } else {
      this.parent[rootQ] = rootP;
      
      if(this.rank[rootQ] == this.rank[rootP])
        this.rank[rootP]++;
    }

    this._count--;
  }
  
  public count(): number {
    return this._count;
  }
}

// tarjan's low link algorithm

function tarjanAlgo(isConnected: number[][]): number {
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