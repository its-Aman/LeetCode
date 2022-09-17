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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, curr = head;
        Stack<ListNode> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        while(slow != null) {
            ListNode next = slow.next;
            slow.next = null;
            stack.push(slow);
            slow = next;
        }
        
        int size = stack.size();
        
        if(size % 2 == 0)
            size--;
        
        while(size-- > 0 && stack.peek() != curr.next) {
            ListNode node = stack.pop();
            ListNode next = curr.next;
            curr.next = node;
            node.next = next;
            curr = next;
        }
        
    }
    
}