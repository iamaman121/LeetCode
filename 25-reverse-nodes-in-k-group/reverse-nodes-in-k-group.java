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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head.next==null) return head;
        ListNode dummy= new ListNode(0);
        dummy.next= head;
        ListNode prevGroupEnd= dummy, curr= head;
        ListNode beg, end;
        int cnt= 0;
        while(curr!=null){
            beg= curr;
            end= curr;
            cnt=0;
            while(cnt<k && end!=null){
                cnt++; end= end.next;
            }
            if(cnt<k){
                prevGroupEnd.next= beg;
                break;
            }
            ListNode reversedHead= reverseList(beg, end);
            prevGroupEnd.next= reversedHead;
            prevGroupEnd= beg;
            curr= end;
        }
        return dummy.next;
    }
    private ListNode reverseList(ListNode start, ListNode end){
        ListNode prev= null, curr= start, nxt= null;
        while(curr!=end){
            nxt= curr.next;
            curr.next= prev;
            prev= curr;
            curr= nxt;
        }
        return prev;
    }
}