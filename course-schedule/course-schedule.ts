

// dfs + stack
function canFinish(numCourses: number, prerequisites: number[][]): boolean {
  const preMap = Array.from(Array(numCourses), () => []),
        visit = Array(numCourses).fill(false),
        stack = [];
    
  for(let [s, d] of prerequisites)
    preMap[s].push(d);
  
  for(let i = 0; i < numCourses; i++)
    if(hasCycle(i))
      return false;

  return true;
  
  function hasCycle(v: number): boolean {
    if(visit[v]){
      if(stack.includes(v))
        return true;

      return false;
    }
    
    visit[v] = true;
    stack.push(v);
    
    for(let deps of preMap[v]){
      if(hasCycle(deps))
        return true;
    }
    
    stack.pop();
    return false;
  }
}


// this is using bfs with constant memory. 
function canFinish_BFS(numCourses: number, prerequisites: number[][]): boolean {
  const preMap = Array.from(Array(numCourses), () => []),
        visit = Array(numCourses).fill(0);
    
  for(let [s, d] of prerequisites)
    preMap[s].push(d);
  
  for(let i = 0; i < numCourses; i++)
    if(hasCycle(i))
      return false;

  return true;
  
  function hasCycle(v: number): boolean {
    if(visit[v] == 1)
      return false;
    
    if(visit[v] == -1)
      return true;
    
    visit[v] = -1;
    
    for(let deps of preMap[v]){
      if(hasCycle(deps))
        return true;
    }
    
    visit[v] = 1;
    return false;
  }
}


// https://www.youtube.com/watch?v=EgI5nU9etnU
function canFinish_NC(numCourses: number, prerequisites: number[][]): boolean {
  const preMap = [],
        visit = new Set<number>();
  
  for(let i = 0; i < numCourses; i++)
    preMap.push([]);
  
  for(let [s, d] of prerequisites)
    preMap[s].push(d);
  
  for(let i = 0; i < numCourses; i++)
    if(!dfs(i))
      return false;
  
  return true;
  
  function dfs(course: number): boolean{
    if(visit.has(course))
      return false;
    
    if(!preMap[course].length)
      return true;
    
    visit.add(course);
    for(let pre of preMap[course])
      if(!dfs(pre))
        return false;
    
    visit.delete(course);
    preMap[course] = [];
    return true; 
  }

}

// was trying to use topological sort since it was mentioned in the hint. But failed to do so.
// at last, we just need to detect if there is a cycle. 
// It was really simple and stupid me was mugging the topological sort! 
function canFinish2(numCourses: number, prerequisites: number[][]): boolean {
  const graph = buildGraph(prerequisites),
        vertices = buildVertices(prerequisites),
        stack = [];
  
  for(let [i, v] of vertices.entries()){
    dfs(v);  
  }
  
  function dfs(v: number): void {
    stack.push(v);
    
    if(!graph.has(v))
      return;
      
    for(let nbr of graph.get(v)) {
      if(!stack.includes(nbr))
        dfs(nbr);
      else
        return;
    }
    
    stack.pop();
  }
  
  return stack.length == 0;
};

function buildVertices(prerequisites: number[][]): Set<number> {
  const set = new Set<number>();
  for(let [s, d] of prerequisites){
    set.add(s);
    set.add(d);
  }
  return set;
}

function buildGraph(list: number[][]): Map<number, number[]>{
  const graph = new Map<number, number[]>();
  
  for(let [s, d] of list)
    if(graph.has(s))
      graph.get(s).push(d);
    else 
      graph.set(s, [d]);

  return graph;
}

class TopologicalSort {
  private _graph: Map<number, number[]>;
  private _vertices: Set<number>;
  private _verticesCount: number;
  private _visited: Map<number, boolean>;
  private _ordering: number[];
  private _i: number;

  constructor(graph: Map<number, number[]>, vertices: Set<number>){
    this._graph = graph;
    this._verticesCount = vertices.size;
    this._vertices = vertices;
    this._ordering = [];

    this.setVisited();

    console.log(this);
  }

  private setVisited(): void {
    this._visited = new Map<number, boolean>();

    for(let [i, v] of this._vertices.entries())
      this._visited.set(v, false);
  }

  public sort(): number[]{
    for(let [i, at] of this._vertices.entries()){
      if(!this._visited.get(at))
        this.dfs(at);
      else
        console.log('sort', at);
    }
    
    return this._ordering;
  }

  private dfs(at: number): void {
    this._visited.set(at, true);

    if(!this._graph.has(at))
      return;

    for(let edge of this._graph.get(at))
      if(!this._visited.get(edge))
        this.dfs(edge);
      else
        console.log('dfs', edge);

    this._ordering.push(at);
  }
}