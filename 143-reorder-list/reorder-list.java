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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, nxt = null;
        while(curr!=null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }         
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode mdl = findMiddle(head);
        ListNode rgt = mdl.next;
        rgt = reverseList(rgt);
        mdl.next = null;
        head = merge(head, rgt);
    }
    private ListNode merge(ListNode lft, ListNode rgt){
        ListNode ans = new ListNode(0);
        ListNode nHead = ans;
        while(lft!=null && rgt!=null){
            ans.next = lft; lft = lft.next; ans = ans.next;
            ans.next = rgt; rgt = rgt.next; ans = ans.next;
        }
        while(lft!=null){
            ans.next = lft; lft = lft.next; ans = ans.next;
        }
        return nHead.next;
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}