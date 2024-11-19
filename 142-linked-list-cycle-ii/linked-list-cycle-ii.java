/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head, fast = slow;
        do{
            slow = slow.next;
            fast = fast.next;
            if(fast!=null) fast = fast.next;
        }
        while(slow!=fast && fast!=null && fast.next!=null);
        if(fast==null || fast.next==null) return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}