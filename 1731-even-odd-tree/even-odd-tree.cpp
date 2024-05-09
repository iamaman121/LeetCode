/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isEvenOddTree(TreeNode* root) {
        if(!root) return true;
        int level=0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int len=q.size();
            if(level&1){
                int prev= 1e6+2;
                while(len--){
                    TreeNode* frnt= q.front();
                    q.pop();
                    if(frnt->val>=prev || frnt->val&1) return false;
                    prev= frnt->val;
                    if(frnt->left) q.push(frnt->left);
                    if(frnt->right) q.push(frnt->right);

                }
            }
            else{
                int prev= 0;
                while(len--){
                    TreeNode* frnt= q.front();
                    q.pop();
                    if(frnt->val<=prev || frnt->val%2==0) return false;
                    prev= frnt->val;
                    if(frnt->left) q.push(frnt->left);
                    if(frnt->right) q.push(frnt->right);

                }
            }
            ++level;
        }
        return true;
    }
};