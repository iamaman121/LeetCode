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
    ListNode* merge2Lists(ListNode* l1, ListNode* l2) {
        if(!l1) return l2;
        else if(!l2) return l1;
        if(l1->val<=l2->val){
            l1->next=merge2Lists(l1->next, l2);
            return l1;
        }
        else{
            l2->next=merge2Lists(l1, l2->next);
            return l2;
        }
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k=(int)lists.size();
        if(k==0) return NULL;
        int si=0,ei=k-1;
        while(si<ei){
            lists[si]=merge2Lists(lists[si],lists[ei]);
            ++si;--ei;
            si=0;
        }
        return lists[0];
    }
};