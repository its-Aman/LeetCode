/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        
        while(node.next != null) {
            prev = node;
            node = node.next;
            prev.val = node.val;
        }

        prev.next = null;
    }
}