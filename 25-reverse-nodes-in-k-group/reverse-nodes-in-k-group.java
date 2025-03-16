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
    private ListNode reverseList(ListNode head) {
        ListNode curr= head, prev= null, nxt= null;
        while(curr!=null){
            nxt= curr.next;
            curr.next= prev;
            prev= curr;
            curr= nxt;
        }
        return prev;
    }
    private ListNode reverseKGroupUtil(ListNode head, int k) {
        ListNode temp= head;
        for(int i=1;i<k && temp!=null;i++){
            temp= temp.next;
        }
        if(temp!=null){
            ListNode ans= reverseKGroupUtil(temp.next, k);
            temp.next= null;
            temp= reverseList(head);
            head.next= ans;
            return temp;
        }
        else return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head.next==null) return head;
        return reverseKGroupUtil(head, k);
    }
}