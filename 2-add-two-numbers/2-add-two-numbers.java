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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), curr = ans;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int add = carry;
            
            if(l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            
            if(add > 9) {
                carry = 1;
                add %= 10;
            } else {
                carry = 0;
            }
            
            curr.next = new ListNode(add);
            curr = curr.next;
        }
                 
        if(carry != 0)
            curr.next = new ListNode(carry);
        
        return ans.next;
    }
}