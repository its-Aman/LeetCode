// https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
/**
 * Definition for Node.
 * class Node {
 *     val: number
 *     next: Node | null
 *     random: Node | null
 *     constructor(val?: number, next?: Node, random?: Node) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *         this.random = (random===undefined ? null : random)
 *     }
 * }
 */

function copyRandomList(head: Node | null): Node | null {
//   so here we need to copy the original list to it's identical list
//   this can be a 3 step process.
//   1. first we'll create copies of node in the original list. 
//       copied node will be residing next to the original node.
  
//   2. In the next phase, we'll assign the random pointer.
  
//   3. In the last phase, we'll elemenate the original nodes from the list.
//      extract the copy nodes to it's seperate list
//      and restore the original list.

//   phase 1 - 
  
  let iter = head,
      next = null;
  
  while(iter) {
    next = iter.next;
    
    let copy = new Node(iter.val);
    iter.next = copy;
    copy.next = next;
    
    iter = next;
  }
  
//   phase 2 -
  
  iter = head;
  
  while(iter){
    if(iter.random){
      iter.next.random = iter.random.next;
    }
    iter = iter.next.next;
  }
  
//   phase 3 -
  
  iter = head;
  let pseudoHead = new Node(),
      copyIter = pseudoHead,
      copy = null;
  
  while(iter){
    next = iter.next.next;
    
    copy = iter.next;
    copyIter.next = copy;
    copyIter = copy;
    
    iter.next = next;
    iter = next;
  }
        
  return pseudoHead.next;        
};