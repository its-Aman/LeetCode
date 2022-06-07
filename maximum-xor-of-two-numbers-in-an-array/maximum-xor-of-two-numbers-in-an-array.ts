// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/Java-O(n)-solution-using-Trie

class TrieNode {
  public children: TrieNode[];
  
  constructor(){
    this.children = [];  
  }
}

function findMaximumXOR(nums: number[]): number {
  let root = new TrieNode(),
      max = Number.MIN_SAFE_INTEGER;
  
  for(let num of nums){
    let curr = root;
    
    for(let i = 31; i >= 0; i--) {
      let currBit = 1 & (num >>> i);
      
      if(!curr.children[currBit])
        curr.children[currBit] = new TrieNode();
      
      curr = curr.children[currBit];
    }
  }
  
  for(let num of nums){
    let curr = root,
        currSum = 0;
    
    for(let i = 31; i >= 0; i--) {
      let currBit = 1 & (num >>> i);
      
      if(curr.children[currBit ^ 1]){
        currSum += (1 << i);
        curr = curr.children[currBit ^ 1];
      } else {
        curr = curr.children[currBit];
      }
    }
    max = Math.max(max, currSum);
  }
  
  return max;
};