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
        if(!l2) return l1;
        ListNode *head,*trav;
        ListNode *temp1=l1,*temp2=l2;
        if(temp1->val<=temp2->val){
            head=temp1;
            trav=temp1;
            temp1=temp1->next;
        }
        else{
            head=temp2;
            trav=temp2;
            temp2=temp2->next;
        }
        while(temp1 and temp2){
            if(temp1->val<=temp2->val){
                trav->next=temp1;
                temp1=temp1->next;
                trav=trav->next;
            }
            else{
                trav->next=temp2;
                temp2=temp2->next;
                trav=trav->next;
            }
        }
        if(temp1){
            trav->next=temp1;
        }
        else if(temp2){
            trav->next=temp2;
        }
        else{
            trav->next=NULL;
        }
        return head;
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