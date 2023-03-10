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
    ListNode H;
    
    public Solution(ListNode head) {
        H = head;
    }
    
    public int getRandom() {
        int scope = 1, pick = 0;
        ListNode curr = H;
        
        while(curr != null) {
            if(Math.random() < (1.0 / scope)) {
                pick = curr.val;
            }
            scope++;
            curr = curr.next;
        }
        
        return pick;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */