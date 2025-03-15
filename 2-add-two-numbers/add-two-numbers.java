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
    private ListNode addTwoNumbersUtil(ListNode l1, ListNode l2) {
        ListNode ans= null, temp= null;
        int carry=0;
        while(l1!=null && l2!=null){
            carry+= l1.val+l2.val;
            if(temp==null){
                ans= l1; temp= l1;
            }
            else{
                temp.next= l1;
                temp= temp.next;
            }
            temp.val= carry%10;
            carry/=10;
            l1= l1.next;
            l2= l2.next;
        }
        while(l1!=null){
            carry+=l1.val;
            temp.next= l1;
            temp= temp.next;
            temp.val= carry%10;
            carry/=10;
            l1= l1.next;
        }
        while(l2!=null){
            carry+=l2.val;
            temp.next= l2;
            temp= temp.next;
            temp.val= carry%10;
            carry/=10;
            l2= l2.next;
        }
        if(carry>0){
            temp.next= new ListNode(carry);
        }
        return ans;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        else if(l2==null) return l1;
        return addTwoNumbersUtil(l1,l2);
    }
}