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
        ListNode slow = head, fast = head, curr = head, pre = null;
        
        while(fast != null) {
            fast = fast.next.next;
            curr = slow;
            slow = slow.next;
            curr.next = pre;
            pre = curr;
        }
        
        int ans = Integer.MIN_VALUE;

        while(slow != null) {
            ans = Math.max(pre.val+slow.val, ans);
            slow = slow.next;
            pre = pre.next;
        }
        
        return ans;
    }
}