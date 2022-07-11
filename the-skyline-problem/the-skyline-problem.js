/**
 * @param {number[][]} buildings
 * @return {number[][]}
 */
// https://leetcode.com/problems/the-skyline-problem/discuss/1477969/javascript-multiset-2408ms
function MultiSet() {
    let tm = {}; // treemap: works for key >= 0
    return { insert, eraseOne, erase, contains, first, last, show }
    function insert(x) {
        tm[x] ? tm[x]++ : tm[x] = 1;
    }
    function eraseOne(x) {
        let occ = tm[x];
        occ > 1 ? tm[x]-- : delete tm[x];
    }
    function erase(x) {
        delete tm[x];
    }
    function contains(x) {
        return tm[x] ? 1 : 0;
    }
    function first() {
        let a = Object.keys(tm);
        return a[0] - '0';
    }
    function last() {
        let a = Object.keys(tm);
        return a[a.length - 1] - '0';
    }
    function show() {
        console.log(tm);
    };
}

var getSkyline = function(buildings) {
  const N = buildings.length,
        buildingPoints = new Array(),
        ms = new MultiSet(),
        ans = new Array();
  
  for(let [x, y, h] of buildings)
    buildingPoints.push([x, -h], [y, h]);

  buildingPoints.sort((a, b) => (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

  ms.insert(0);
  let pre = 0;
  
  for(let [x, h] of buildingPoints) {
    if(h < 0)
      ms.insert(-h);
    else
      ms.eraseOne(h);
    
    let curr = ms.last();
    
    if(curr != pre) {
      ans.push([x, curr]);
      pre = curr;
    }
  }
  
  return ans;
};