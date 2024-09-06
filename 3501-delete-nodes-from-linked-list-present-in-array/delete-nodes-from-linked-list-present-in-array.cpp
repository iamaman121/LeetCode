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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int> valuesToRemove(nums.begin(),nums.end());
        while(head!=NULL && valuesToRemove.count(head->val)==1){
            head= head->next;
        }
        if(head!=NULL){
            ListNode* temp= head;
            while(temp->next){
                if(valuesToRemove.count(temp->next->val)==1){
                    temp->next= temp->next->next;
                }
                else temp= temp->next;
            }
        }
        return head;
    }
};