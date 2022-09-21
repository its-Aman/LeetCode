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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || k == 0) return head;
        
        ListNode curr = head, node = head;
        int len = 1;
        
        for(;curr != null && curr.next != null; ++len, curr = curr.next){}
        
        k %= len;
        
        if(k == 0) return head;

        for(; len - k - 1 > 0; --len, node = node.next){}

        curr.next = head;
        head = node.next;
        node.next = null;
        
        return head;
    }
}