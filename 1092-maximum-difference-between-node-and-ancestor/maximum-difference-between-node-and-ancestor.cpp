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
    int helper(TreeNode* root, int maxm, int minm){
        if(root == NULL) return 0;
        int ans=max(abs(maxm-root->val),abs(minm-root->val));
        maxm=max(maxm,root->val);
        minm=min(minm,root->val);
        ans=max(ans, helper(root->left, maxm, minm));
        ans=max(ans, helper(root->right, maxm, minm));
        return ans;
    }
    int maxAncestorDiff(TreeNode* root) {
        return helper(root, root->val, root->val);
    }
};