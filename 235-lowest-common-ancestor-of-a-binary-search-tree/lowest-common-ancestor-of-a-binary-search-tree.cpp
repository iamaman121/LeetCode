/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    int helper(TreeNode* root, TreeNode* p, TreeNode* q, TreeNode* &ans){
        if(!root) return 0;
        int cval=0;
        if(root==p || root==q) cval=1;
        int lft=helper(root->left, p, q, ans);
        int rgt=helper(root->right, p, q, ans);
        if(cval+lft+rgt==2){
            if(ans==NULL) ans=root;
            return 1;
        }
        return cval+lft+rgt;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* ans=NULL;
        helper(root, p, q, ans);
        return ans;
    }
};