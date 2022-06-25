// https://leetcode.com/problems/reaching-points/discuss/375429/Detailed-explanation.-or-full-through-process-or-Java-100-beat

function reachingPoints(sx: number, sy: number, tx: number, ty: number): boolean {
  while(sx < tx && sy < ty)
    if(ty > tx)
      ty %= tx;
    else
      tx %= ty;
  
  if(sx == tx && sy <= ty && (ty - sy) % sx == 0)
    return true;
  
  if(sy == ty && sx <= tx && (tx - sx) % sy == 0)
    return true;
  
  return false;
};