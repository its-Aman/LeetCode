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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode start) {
        if(start == null || start.next == null)
            return start;
        
        ListNode mid = this.findMid(start);
        ListNode left = this.mergeSort(start);
        ListNode right = this.mergeSort(mid);
        
        return this.mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 != null && l2 != null) {
            ListNode node;
            
            if(l1.val <= l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
        
            node.next = mergeTwoLists(l1, l2);
            return node;
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else {
            return null;
        }
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head, 
                    fast = head, 
                    prev = new ListNode(-1, slow);
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
                
        prev.next = null;

        return slow;
    }
}