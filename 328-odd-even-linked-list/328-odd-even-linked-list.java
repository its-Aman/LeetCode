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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode oddHead = head;
        ListNode evenHead = oddHead.next;
        ListNode tempEven = evenHead;

        while(oddHead != null && oddHead.next != null && tempEven != null && tempEven.next != null) {
            if(oddHead.next != null) {
                oddHead.next = oddHead.next.next;
                oddHead = oddHead.next;
            }
    
            if(tempEven.next != null){
                tempEven.next = tempEven.next.next;
                tempEven = tempEven.next;
            }
        }
    
        if(oddHead != null)
            oddHead.next = evenHead;
        
        return dummy.next;
    }
}