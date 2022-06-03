function findOrder(numCourses: number, prerequisites: number[][]): number[] {
  return KhanAlgoWithTopologicalSort(numCourses, prerequisites);
}

function DFS_Stack(numCourses: number, prerequisites: number[][]): number[] {
  const adj = Array.from(Array(numCourses), () => []),
        visit = Array(numCourses).fill(false),
        stack = [],
        ans = [];
  
  for(let [s, d] of prerequisites)
    adj[s].push(d);
  
  for(let i = 0; i < numCourses; i++){
    if(hasCycle(i))
      return [];
  }
  
  return ans;
  
  function hasCycle(v: number): boolean {
    if(visit[v]){
      if(stack.includes(v))
        return true;
      
      return false;
    }
    visit[v] = true;
    stack.push(v);
    
    for(let deps of adj[v]){
      if(hasCycle(deps))
        return true;
    }
    
    ans.push(stack.pop());
    
    return false;
  }
};


function KhanAlgoWithTopologicalSort(numCourses: number, prerequisites: number[][]): number[] {
  const adj = Array.from(Array(numCourses), () => []),
        in_degree = Array(numCourses).fill(0),
        order = [],
        q = [];
  let i = numCourses;
    
  for(let [s, d] of prerequisites)
    adj[s].push(d);

  for(let i = 0; i < numCourses; i++)
    for(let deps of adj[i])
      in_degree[deps] += 1; 
  
  // console.log({adj, in_degree})
  
  for(let i = 0; i < numCourses; i++)
    if(in_degree[i] == 0)
      q.unshift(i);

  while(q.length) {
    const at = q.pop();
    order[--i] = at;
    
    for(let deps of adj[at]){
      in_degree[deps] -= 1;
      
      if(in_degree[deps] == 0)
        q.unshift(deps);
    }
  }
    
  // console.log({order, i});
  
  if(i > 0)
    return [];

  return order;
  
}