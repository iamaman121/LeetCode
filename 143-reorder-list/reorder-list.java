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
    private ListNode getMiddleNode(ListNode head){
        ListNode slow= head, fast= head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    private ListNode reverseLL(ListNode head){
        ListNode curr= head, nxt= null, prev= null;
        while(curr!=null){
            nxt= curr.next;
            curr.next= prev;
            prev= curr;
            curr= nxt;
        }
        return prev;
    }
    private ListNode merge(ListNode A, ListNode B){
        if(B==null) return A;
        ListNode nxt= merge(A.next, B.next);
        B.next= nxt;
        A.next= B;
        return A;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return ;
        ListNode middle= getMiddleNode(head);
        ListNode right= middle.next;
        ListNode left= head;
        middle.next= null;
        right= reverseLL(right);
        head= merge(left, right);
    }
}