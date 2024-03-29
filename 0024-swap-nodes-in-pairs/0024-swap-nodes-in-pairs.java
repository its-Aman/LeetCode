/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1, head);
        
        ListNode prev = dummy, curr = head, next = head.next;
        
        while(next != null) {
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            
            if(curr.next == null) break;

            prev = curr;
            curr = curr.next;
            next = curr.next;
        }
        
        return dummy.next;
    }
}