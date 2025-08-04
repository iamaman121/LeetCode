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
    private ListNode reverseLL(ListNode head){
        ListNode curr = head, nxt= null, prev= null;
        while(curr!=null){
            nxt= curr.next;
            curr.next= prev;
            prev= curr;
            curr= nxt;
        }
        return prev;
    }
    private void printLL(ListNode list){
        while(list!=null){
            System.out.print(list.val+" ");
            list= list.next;
        }
        System.out.println();
    }
    private ListNode merge(ListNode a, ListNode b){
        if(a==null && b==null) return null;
        else if(b==null) return a;
        ListNode head= a;
        ListNode curr= a; a= a.next;
        curr.next= b; curr= curr.next;
        b= b.next; curr.next= null;
        curr.next= merge(a, b);
        return head;
    }
    public void reorderList(ListNode head) {
        if(head== null || head.next== null || head.next.next==null) return;
        ListNode slow= head, fast= head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        ListNode list1= head;
        ListNode list2= slow.next;
        slow.next= null;
        list2= reverseLL(list2);
        // printLL(list1); printLL(list2);
        head= merge(list1, list2);
    }
}