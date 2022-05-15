/*
https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/discuss/2038534/Sliding-Window

function maximumWhiteTiles(tiles: number[][], carpetLen: number): number {
  let res = 0,
      j = 0,
      cover = 0;
  
  tiles.sort((a, b) => a[0] - b[0]);
  
  for(let i = 0; res < carpetLen && i < tiles.length;){
    const [jstart, jend] = tiles[j],
          [istart, iend] = tiles[i];
    
    if(j == i || jstart + carpetLen > iend){
      cover += Math.min(carpetLen, iend - istart + 1);
      res = Math.max(res, cover);
      ++i;
    } else {
      let partial = Math.max(0, jstart + carpetLen - istart);
      res = Math.max(res, cover + partial);
      cover -= (jend - jstart + 1);
      ++j
    }
  }
  
  return res;
};

*/

// https://www.youtube.com/watch?v=i6OZgQOc8oE

function maximumWhiteTiles(tiles: number[][], carpetLen: number): number {
  tiles.sort((a, b) => a[0] - b[0]);
  
  const N: number = tiles.length,
        prefixSum: number[] = [tiles[0][1] - tiles[0][0] + 1];
  let ans: number = 0;
  
  for(let i = 1; i < N; i++){
    prefixSum[i] = prefixSum[i - 1] + (tiles[i][1] - tiles[i][0] + 1);
  }
  
  for(let i = 0; i < N; i++){
    let leftEnd = tiles[i][0],
        rightEnd = tiles[i][0] + carpetLen - 1;
    
    let l = i,
        r = N - 1,
        left = i,
        right = i - 1;
    
    while(l <= r){
      const mid = l + Math.floor((r-l)/2);
      if(tiles[mid][1] <= rightEnd){
        right = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    
    let curr = 0;
    
    if(right != i - 1){
      curr += prefixSum[right];
      if(left > 0)
        curr -= prefixSum[left - 1];
    }
    
    if(right + 1 < N)
      curr += Math.max(0, rightEnd - tiles[right + 1][0] + 1);
    
    ans = Math.max(ans, curr);
  }
  
  return ans;
}