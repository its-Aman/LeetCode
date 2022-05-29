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
function sortList(head: ListNode | null): ListNode | null {
  if(!head || !head.next)
    return head;
  
  let tail = new ListNode(),
      nextSubList = new ListNode(),
      n = getCount(head),
      start = head,
      dummyHead = new ListNode();
  
  for(let size = 1; size < n; size *= 2){
    tail = dummyHead;
    while(start){
      if(!start.next){
        tail.next = start;
        break;
      }
      
      let mid = split(start, size);
      merge(start, mid);
      start = nextSubList;
    }
    start = dummyHead.next;
  }
  
  return dummyHead.next;

  function split(start: ListNode | null, size: number): ListNode | null {
    let midPrev = start,
        end = start.next;
    for(let i = 1; i < size && (midPrev.next || end.next); i++) {
      if(end.next)
        end = end.next.next ? end.next.next : end.next;

      if(midPrev.next)
        midPrev = midPrev.next;
    }
    let mid = midPrev.next;
    midPrev.next = null;
    nextSubList = end.next;
    end.next = null;
    return mid;
  }
  
  function merge(l1: ListNode | null, l2: ListNode | null): void {
    let dummyHead = new ListNode(),
      newTail = dummyHead;
    
    while(l1 && l2){
      if(l1.val < l2.val){
        newTail.next = l1;
        l1 = l1.next;
      } else {
        newTail.next = l2;
        l2 = l2.next;        
      }
      newTail = newTail.next;
    }
  
    newTail.next = l1 ? l1 : l2;
  
    while(newTail.next)
      newTail = newTail.next;
  
    tail.next = dummyHead.next;
    tail = newTail;
  }

  function getCount(head: ListNode | null): number { 
    let count = 0,
        node = head;

    while(node){
      count++;
      node = node.next;
    }

    return count;
  }
}
*/

function sortList(head: ListNode | null): ListNode | null {
  
  if(!head || !head.next)
    return head;
  
  let temp = null,
      slow = head,
      fast = head;
  
  while(fast && fast.next){
    temp = slow;
    slow = slow.next;
    fast = fast.next.next;
  }
  temp.next = null;
  
  let l1 = sortList(head),
      l2 = sortList(slow);
  
  return mergeList(l1, l2);
}

function mergeList(l1: ListNode | null, l2: ListNode | null): ListNode | null {
  let ptr = new ListNode(),
      curr = ptr;
  
  while(l1 || l2){
    
    if(!l1){
      curr.next = l2;
      break;
    }
    
    if(!l2){
      curr.next = l1;
      break;
    }
    
    if(l1.val < l2.val){
      curr.next = l1;
      l1 = l1.next;
    } else {
      curr.next = l2;
      l2 = l2.next;
    }
    
    curr = curr.next;
  }
  
  return ptr.next;
}