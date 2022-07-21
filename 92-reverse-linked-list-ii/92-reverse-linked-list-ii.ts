/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
  if(left == right)
    return head;
  
  let curr = head,
      prev = null,
      startNodePrev = null,
      startNode = null,
      idx = 0;
  
  while(curr) {
    idx += 1;
    
    if(idx == left) {
      startNodePrev = prev;
      startNode = curr;
    }

    if(idx == right) {
      let next = curr.next;
      
      curr.next = prev;
      prev = curr;
      curr = next;
      break;
    }
    
    if(idx >= left) {
      let next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    } else {
      prev = curr;
      curr = curr.next;
    }
  }
  
  if(startNode)
    startNode.next = curr;
  
   if(startNodePrev?.next)
     startNodePrev.next = prev;
  
  if(head == startNode)
    return prev;
    
  return head;
};