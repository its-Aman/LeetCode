// https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
function minimumTotal(triangle: number[][]): number {
  // return minimumTotal_TopDownDP(triangle);
  return minimumTotal_BottomUpDP(triangle);
}

function minimumTotal_TopDownDP(triangle: number[][]): number {
	for(let level = 1; level < triangle.length; level++) 
		for(let i = 0; i <= level; i++)
			triangle[level][i] += Math.min(
                                    triangle[level - 1][Math.min(i, triangle[level - 1].length - 1)], 
                                    triangle[level - 1][Math.max(i - 1, 0)]);
	return Math.min(...triangle[triangle.length - 1]); 
}


function minimumTotal_BottomUpDP(triangle: number[][]): number {
  const height = triangle.length,
        minLen = Array.from(triangle[height - 1]);
  
  for(let layer = height - 2; layer >= 0; layer--)
    for(let i = 0; i <= layer; i++)
      minLen[i] = triangle[layer][i] + Math.min(minLen[i], minLen[i + 1]);
  
  return minLen[0];
}

function minimumTotal_old_wrong(triangle: number[][]): number {
  const height = triangle.length;
  let ans = triangle[0][0], i = 0;
  
  for(let h = 1; h < height; h++)
    if(triangle[h][i] < triangle[h][i + 1])
      ans += triangle[h][i];
    else
      ans += triangle[h][++i];
  
  return ans;
};