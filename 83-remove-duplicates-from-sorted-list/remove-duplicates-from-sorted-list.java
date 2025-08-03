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
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null) return head;
        ListNode temp= head.next;
        while(temp!=null && temp.val==head.val){
            temp= temp.next;
        }
        head.next= deleteDuplicates(temp);
        return head;
    }
}