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
    private int getLengthLL(ListNode head){
        int len= 0;
        while(head!=null){
            len++;
            head= head.next;
        }
        return len;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len= getLengthLL(head);
        if(len==n) return head.next;
        ListNode temp= head;
        for(int i=1;i<=len-n-1;i++) temp= temp.next;
        temp.next= temp.next.next;
        return head;
    }
}