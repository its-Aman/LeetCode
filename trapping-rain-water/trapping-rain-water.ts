function trap(H:number[]): number {

  const N = H.length;
  let l = 0,
      r = N - 1,
      lMax = 0,
      rMax = N - 1,
      ans = 0;
  
  while(l <= r) {
    if(H[l] <= H[r]) {
      if(H[l] >= H[lMax]) {
        lMax = l;
      } else {
        ans += H[lMax] - H[l];
      }
      l++;
    } else {
      if(H[r] >= H[rMax]) {
        rMax = r;
      } else {
        ans += H[rMax] - H[r];
      }
      r--;
    }   
  }
  return ans;
}

function trapMy(height: number[]): number {
  const N = height.length,
        mono = new Array<number>(N),
        dp = new Array<number>(N).fill(-1);
  
  let ans = 0;
  
  for(let i = 0; i < N; i++) {
    let max = i;
    
    for(let j = i + 1; j < N; j++) {
      if(height[max] == height[j])
        max = j;
      
      if(height[j] > height[max]){
        max = j;
        break;
      }
    }
    
    mono[i] = max;
  }
  
  mono.forEach((m, i) => console.log(i, height[i], m, height[m]))

  if(height[0] != 0)
    dfs(0, mono[0]);
  else
    dfs(1, mono[1]);

  
  function dfs(l: number, r: number) {
    if(r - l <= 1 || height[l] == 0 || l >= N || r >= N) {
      return;
    }

    const minH = Math.min(height[l], height[r]),
          diff = r - l - 1,
          totalWater = minH * diff,
          buildings = calcBuildingHeightInBetween(l + 1, r);

    ans += totalWater - buildings;

    console.log({l, r, minH, diff, totalWater, buildings, ans})
    
    for(let i = r; i < N; i++) {
      if(i == mono[i])
        continue;
      else
        return dfs(i, mono[i]);
    }
  }
  
  function calcBuildingHeightInBetween(l: number, r: number): number {
    let ans = 0;
    for(let i = l; i < r; i++)
      ans += height[i];
    return ans;
  }
  
  return ans;
};