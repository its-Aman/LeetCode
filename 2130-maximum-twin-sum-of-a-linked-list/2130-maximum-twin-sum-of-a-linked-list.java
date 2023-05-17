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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack();
        
        while(fast != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next;

            if(fast == null) break;
            
            fast = fast.next;            
        }
        
        int ans = Integer.MIN_VALUE;

        while(slow != null) {
            int top = stack.pop();
            ans = Math.max(top+slow.val, ans);
            slow = slow.next;
        }
        
        return ans;
    }
}