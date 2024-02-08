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
    int helper(TreeNode* root, int &ans) {
        if(!root) return 0;
        int lft= helper(root->left, ans);
        int rgt= helper(root->right, ans);
        ans=max(ans, root->val+max(0,max(lft,rgt)));
        ans=max(ans, max(lft,0)+root->val+max(0, rgt));
        return root->val + max(0, max(lft, rgt));
    }
    int maxPathSum(TreeNode* root) {
        int ans= -1e9;
        helper(root, ans);
        return ans;
    }
};