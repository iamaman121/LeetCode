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
#define data val
class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        vector<ListNode*> vec;
        ListNode *temp= head;
        int sum= 0;
        while(temp!=NULL){
            if(temp->data==0) vec.push_back(temp);
            temp= temp->next;
        }
        for(int i=vec.size()-2;i>=0;i--){
            sum=0;
            temp=vec[i];
            while(temp!=vec[i+1]){
                sum+= temp->data;
                temp= temp->next;
            }
            vec[i]->data= sum;
            if(i==vec.size()-2) vec[i]->next= vec[i+1]->next;
            else vec[i]->next= vec[i+1];
        }
        return head;
    }
};