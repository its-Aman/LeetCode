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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head, newHead = new ListNode(-1, head), prev = newHead;

		while (n-- > 0 && fast != null)
			fast = fast.next;

		while (fast != null) {
			prev = slow;
			fast = fast.next;
			slow = slow.next;
		}

		prev.next = slow.next;

		return newHead.next;
	}
}