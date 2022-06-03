function findOrder(numCourses: number, prerequisites: number[][]): number[] {
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