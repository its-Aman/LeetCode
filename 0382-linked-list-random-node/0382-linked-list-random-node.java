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
    int[] list;
    int N;
    Random rand;
    
    public Solution(ListNode head) {
        ListNode cnt = head;
        rand = new Random();
        
        while(cnt != null) {
            cnt = cnt.next;
            N++;
        }
        
        list = new int[N];
        cnt = head;
        int i = 0;
        
        while(i < N) {
            list[i] = cnt.val;
            i++;
            cnt = cnt.next;
        }
    }
    
    public int getRandom() {
        int n = rand.nextInt(N);
        return list[n];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */