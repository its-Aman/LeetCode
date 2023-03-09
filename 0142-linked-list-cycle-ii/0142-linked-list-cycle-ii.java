/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode turtle = head, hare = head;
        
        while(turtle != null) {
            turtle = turtle.next;

            if(hare != null) {
                hare = hare.next;
            }
            if(hare != null) {
                hare = hare.next;
            }
            
            if(hare == null && turtle == null) {
                return null;
            }
            
            if(hare == turtle) {
                break;
            }
        }
        
        hare = head;
        
        while(turtle != hare) {
            turtle = turtle.next;
            hare = hare.next;
        }
        
        return turtle;
    }
}