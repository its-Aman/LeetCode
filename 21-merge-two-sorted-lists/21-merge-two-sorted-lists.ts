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
  let root = new ListNode(0),
        head = root;
  
  while(list1 && list2) {
    if(list1.val < list2.val) { 
      head.next = list1;
      list1 = list1.next;
    } else {
      head.next = list2;
      list2 = list2.next;
    }
    head = head.next;
  }
  
  while(list1) {
    head.next = list1;
    list1 = list1.next;
    head = head.next;
  }
    
  while(list2) {
    head.next = list2;
    list2 = list2.next;
    head = head.next;
  }

  return root.next;
};