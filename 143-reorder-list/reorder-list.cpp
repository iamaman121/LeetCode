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
    ListNode* reverseList(ListNode* head) {
        if(!head || head->next==NULL) return head;
        ListNode* nhead=reverseList(head->next);
        head->next->next=head;
        head->next=NULL;
        return nhead;
    }
    void reorderList(ListNode* head) {
        if(!head || head->next==NULL || head->next->next==NULL) return ;
        int len=0;
        ListNode* lft=head;
        while(lft){
            ++len;
            lft=lft->next;
        }
        ListNode *rgt=NULL, *temp=head;
        for(int i=0;i<(len+1)/2-1;++i){
            temp=temp->next;
        }
        rgt=temp->next;
        temp->next=NULL;
        lft=head;
        rgt=reverseList(rgt);
        ListNode *nhead=NULL;
        temp=NULL;
        while(lft){
            if(!nhead){
                nhead=lft;
                temp=lft;
                lft=lft->next;
                
            }
            else{
                temp->next=lft;
                temp=temp->next;
                lft=lft->next;
            }
            if(rgt){
                temp->next=rgt;
                temp=temp->next;
                rgt=rgt->next;
            }
            temp->next=NULL;
        }
        head= nhead;
    }
};