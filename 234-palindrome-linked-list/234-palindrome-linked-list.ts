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

function isPalindrome(head: ListNode | null): boolean {
  let slow = head,
      fast = head,
      stack = [];
  
  while(fast && fast.next) {
    stack.push(slow.val);
    slow = slow.next;
    fast = fast.next;
    fast = fast.next;
  }
  
  if(fast)
    slow = slow.next;

  while(slow) {
    if(stack[stack.length - 1] != slow.val)
      return false;
    stack.pop();
    slow = slow.next;
  }
  
  return true;
};