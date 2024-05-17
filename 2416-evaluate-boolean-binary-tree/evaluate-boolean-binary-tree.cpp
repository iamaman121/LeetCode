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
    bool evaluateTree(TreeNode* root) {
        if(root->left==NULL && root->right==NULL){
            return (bool)root->val;
        }
        bool ans;
        if(root->val==2){
            ans= false;
            if(root->left) ans= ans || evaluateTree(root->left);
            if(root->right) ans= ans || evaluateTree(root->right);
        }
        else if(root->val==3){
            ans= true;
            if(root->left) ans= ans && evaluateTree(root->left);
            if(root->right) ans= ans && evaluateTree(root->right);
        }
        return ans;
    }
};