function spiralOrder(matrix: number[][]): number[] {
  const M = matrix.length,
        N = matrix[0].length,
        ans = [];
  let top = 0,
      right = N - 1,
      bottom = M - 1,
      left = 0;
  
  while(top <= bottom && left <= right){

    for(let i = left; i <= right; i++)
      ans.push(matrix[top][i]);
    
    for(let i = top + 1; i <= bottom; i++)
      ans.push(matrix[i][right]);

    if(left < right && top < bottom){
      for(let i = right - 1; i > left; i--)
          ans.push(matrix[bottom][i]);

      for(let i = bottom; i > top; i--)
          ans.push(matrix[i][left]);
    }
    
    top++;
    right--;
    bottom--;
    left++;
  }
  
  return ans;
};