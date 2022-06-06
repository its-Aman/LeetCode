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

function getIntersectionNode(headA: ListNode | null, headB: ListNode | null): ListNode | null {
  const nodeA = headA,
        nodeB = headB;
  
  while(headA != headB){
    if(headA)
      headA = headA.next;
    else
      headA = nodeB;

    if(headB)
      headB = headB.next;
    else
      headB = nodeA;
  }
  
  return headA;  
};