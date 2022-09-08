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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}