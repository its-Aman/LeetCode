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
    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length, i = 1;
        
        if(N == 0) {
            return null;
        }
        
        if(N == 1) {
            return lists[0];
        }
        
        while(i < N) {
            for(int j = 0; j < N - i; j += i*2) {
                lists[j] = merge2List(lists[j], lists[i+j]);
            }
            i *= 2;
        }
        
        return lists[0];
    }
    
    private ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), curr = head;
        
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                curr.next = l2;
                break;
            }

            if(l2 == null) {
                curr.next = l1;
                break;
            }
            
            if(l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            
            curr = curr.next;
        }
        
        return head.next;
    }
}