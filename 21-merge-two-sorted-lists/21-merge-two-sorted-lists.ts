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

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  let newListHead = new ListNode(),
        curr = newListHead;
  
  while(list1 || list2){
    if(!list2){
      curr.next = list1;
      break;
    }

    if(!list1){
      curr.next = list2;
      break;
    }
    
    if(list1.val < list2.val){
      curr.next = list1;
      list1 = list1.next;
    } else {
      curr.next = list2;
      list2 = list2.next;
    }

    curr = curr.next;
  }
  
  return newListHead.next;
};