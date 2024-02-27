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
    int ans=0;
    int fun(TreeNode* root){
        if(!root) return 0;
        int lht=fun(root->left);
        int rht=fun(root->right);
        ans=max(ans,1+lht+rht);
        return 1+max(lht,rht);
    }
    int diameterOfBinaryTree(TreeNode* root) {
        int res=fun(root);
        ans=max(ans,res);
        return ans-1;
    }
};