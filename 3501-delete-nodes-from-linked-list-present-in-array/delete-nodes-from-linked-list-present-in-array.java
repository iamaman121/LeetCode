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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> valuesToRemoveFromList= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            valuesToRemoveFromList.add(nums[i]);
        }
        while(head!=null && valuesToRemoveFromList.contains(head.val)){
            head= head.next;
        }
        ListNode temp= head;
        if(head!=null){
            while(temp.next!=null){
                if(valuesToRemoveFromList.contains(temp.next.val)){
                    temp.next= temp.next.next;
                }
                else{
                    temp= temp.next;
                }
            }
        }
        return head;
    }
    
}