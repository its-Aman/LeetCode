/**
 * The knows API is defined in the parent class Relation.
 * isBadVersion(version: number): boolean {
 *     ...
 * };
 */

var solution = function(isBadVersion: any) {

    return function(N: number): number {
      let lo = 1,
          hi = N;
      
      while(lo < hi){
        const mid = lo + Math.floor((hi - lo) / 2);
        
        if(isBadVersion(mid))
          hi = mid;
        else
          lo = mid + 1;
      }
      
      return lo;
    };
};