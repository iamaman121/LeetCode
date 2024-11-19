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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        do{
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }
        while(slow!=fast && fast!=null && fast.next!=null);
        if(fast==null || fast.next==null) return false;
        return true;
    }
}