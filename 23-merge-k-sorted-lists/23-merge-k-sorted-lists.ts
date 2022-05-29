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

/*
function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
  
  if(!lists || !lists.length || (lists.length == 1 && !lists[0]))
    return null;
  
  let result = new ListNode();
  
  for(let i = 0; i < lists.length; i++){
    result = merge2List(result, lists[i]);
  }
  
  return result.next;
};
*/

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
  
  if(!lists || !lists.length || (lists.length == 1 && !lists[0]))
    return null;
  
  let interval = 1;  

  while(interval < lists.length) {
    for(let i = 0; i < (lists.length - interval); i += (interval * 2)){
      lists[i] = merge2List(lists[i], lists[i + interval]);
    }
    interval *= 2;    
  }
  
  return lists[0];
};

function merge2List(l1: ListNode | null, l2: ListNode | null): ListNode | null {
  let newListHead = new ListNode(),
      curr = newListHead;
  
  while(l1 || l2){
    
    if(!l1){
      curr.next = l2;
      break;
    }

    if(!l2){
      curr.next = l1;
      break;
    }
    
    if(l1.val > l2.val) {
      curr.next = l2;
      l2 = l2.next;
    } else {
      curr.next = l1;
      l1 = l1.next;
    }
    curr = curr.next;
  }
  
  return newListHead.next;
}