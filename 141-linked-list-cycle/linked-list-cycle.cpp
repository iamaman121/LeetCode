/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head==NULL || head->next==NULL) return false;
        ListNode *fast=head, *slow=head;
        while(fast && slow && fast->next){
            fast=fast->next->next;
            slow=slow->next;
            if(!fast || !slow || fast==slow) break;
        }
        if(fast && fast==slow) return true;
        else return false;
    }
};