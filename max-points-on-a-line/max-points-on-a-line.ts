// https://leetcode.com/problems/max-points-on-a-line/discuss/47124/C%2B%2B-slope-counter

function maxPoints(points: number[][]): number {
  const N = points.length;
  let ans = 0;
  
  for(let i = 0; i < N; i++) {
    const [x1, y1] = points[i],
          map = new Map<string, number>();
    let dup = 1;
    
    for(let j = i + 1; j < N; j++) {
      const [x2, y2] = points[j];
      
      if(x1 == x2 && y1 == y2) {
        dup++;
      } else {
        const dx = x2 - x1,
              dy = y2 - y1,
              g = gcd(dx, dy),
              key = `${dx/g}-${dy/g}`;
        
        if(!map.has(key))
          map.set(key, 0);
        
        map.set(key, map.get(key) + 1);
      }
    }
    
    ans = Math.max(ans, dup);
    for(let [key, val] of map)
      ans = Math.max(ans, val + dup);
  }
  
  return ans;
};

function gcd(a: number, b: number): number {
  if(!a)
    return b;
  return gcd(b % a, a);
}