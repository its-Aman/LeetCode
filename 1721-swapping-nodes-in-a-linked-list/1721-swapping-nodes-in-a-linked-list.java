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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode Head = new ListNode(-1, head),
            node = Head.next,
            lastK = Head.next, lastKPrev = Head,
            firstK = Head.next, firstKPrev = Head;
                
        while(node != null) {
            if(k <= 0) {
                lastKPrev = lastK;
                lastK = lastK.next;
            }
            
            node = node.next;
            k--;

            if(k > 0) {
                firstKPrev = firstK;
                firstK = firstK.next;
            }
        }
        
        firstKPrev.next = lastK;
        lastKPrev.next = firstK;
        var next = firstK.next;
        firstK.next = lastK.next;
        lastK.next = next;
        
        
        return Head.next;
    }
}