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

function partition(head: ListNode | null, X: number): ListNode | null {
  let before_dummy = new ListNode(0),
      before = before_dummy,
      after_dummy = new ListNode(0),
      after = after_dummy;
  
  while(head) {
    if(head.val < X){
      before.next = head;
      before = before.next;
    } else {
      after.next = head;
      after = after.next;
    }
    
    head = head.next;
  }
  
  after.next = null;
  before.next = after_dummy.next;
  return before_dummy.next;
}

function partition_old(head: ListNode | null, X: number): ListNode | null {
  let curr = head,
      prev = null,
      Q = [],
      i = 0;
  
  while(curr) {
    if(curr.val < X) {
      const next = curr.next;
      
      if(prev)
        prev.next = curr.next;
      
      curr.next = null;
      Q.push(curr);
      curr = next;
      
      if(i == 0)
        head = curr;
      else
        i += 1;
        
    } else {
      prev = curr;
      curr = curr.next;
      i += 1;
    }
    
  }
  
  // console.log(head, Q);
  
  let dummyHead = new ListNode(0);
  curr = dummyHead;
  i = 0;
  
  while(i < Q.length) {
    curr.next = Q[i++];
    curr = curr.next;
  }
  
  // console.log(dummyHead, head)
  curr.next = head;
  
  return dummyHead.next;
};