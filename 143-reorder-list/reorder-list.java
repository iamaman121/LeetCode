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
    private int getLength(ListNode head) {
        int len=0;
        while(head!=null){
            len++; head=head.next;
        }
        return len;
    }
    private ListNode getNode(ListNode head, int n){
        for(int i=1;i<n;i++) head= head.next;
        return head;
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
        int len= getLength(head);
        int half= (len+1)/2;
        ListNode middle= getNode(head,half);
        ListNode right= middle.next;
        ListNode left= head;
        middle.next= null;
        right= reverseLL(right);
        head= merge(left, right);
    }
}