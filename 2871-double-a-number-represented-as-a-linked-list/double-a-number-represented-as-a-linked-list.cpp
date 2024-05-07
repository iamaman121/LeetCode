/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* doubleItHelper(ListNode* head, int &carry) {
        head->val=2*head->val;
        if(head->next==NULL){
            head->val+= carry;
            carry= head->val/10;
            head->val= head->val%10;
            return head;
        }   
        ListNode* nxt= doubleItHelper(head->next, carry);
        head->val+= carry;
        carry= head->val/10;
        head->val= head->val%10; 
        head->next= nxt;
        return head;
    }
    ListNode* doubleIt(ListNode* head) {
        if(!head) return head;
        int carry=0;
        head= doubleItHelper(head, carry);
        if(carry){
            head= new ListNode(carry, head);
        }
        return head;
    }
};