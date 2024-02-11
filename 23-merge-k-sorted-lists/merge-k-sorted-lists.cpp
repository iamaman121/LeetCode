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
struct compare{
    bool operator()(ListNode* a, ListNode* b){
        return a->val>b->val;
    }
};
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k= (int)lists.size();
        if(k==0) return NULL;
        priority_queue<ListNode*, vector<ListNode*>, compare> pq;
        for(int i=0;i<k;++i){
            if(lists[i]) pq.push(lists[i]);
        }
        if(pq.empty()) return NULL;
        ListNode *temp=NULL, *last=NULL, *curr=NULL;
        while(!pq.empty()){
            curr=pq.top();
            pq.pop();
            if(curr->next) pq.push(curr->next);
            if(!last){
                last= temp= curr;
            }
            else{
                temp->next= curr;
                temp=temp->next;
            }
        }
        if(temp) temp->next=NULL;
        return last;
    }
};