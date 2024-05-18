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
    int distributeCoinsHelper(TreeNode* root, int &ans){
        if(!root) return 0;
        int lft= distributeCoinsHelper(root->left, ans);
        int rgt= distributeCoinsHelper(root->right, ans);
        int val= root->val+ lft+ rgt;
        ans+= abs(val-1);
        return val-1;
    }
    int distributeCoins(TreeNode* root) {
        int ans=0;
        distributeCoinsHelper(root, ans);
        return ans;
    }
};