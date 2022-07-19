function generate(N: number): number[][] {
  const ans = new Array(0);
  ans.push([1]);
  
  if(N == 1)
    return ans;
  
  ans.push([1, 1]);

  if(N == 2)
    return ans;

  for(let i = 2; i < N; i++) {
    let row = [1];
    
    for(let j = 1; j < i; j++){
      row.push(ans[i-1][j - 1] + ans[i-1][j]);
    }

    row.push(1);
    ans.push(row);
  }
  
  return ans;
};