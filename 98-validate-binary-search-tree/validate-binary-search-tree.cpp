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
 #define lint long int
class Solution {
public:
    bool helper(TreeNode* root, lint minm, lint maxm){
        if(!root) return true;
        return (lint)root->val>minm && (lint)root->val<maxm && helper(root->left, minm, root->val) && helper(root->right, root->val, maxm); 
    }
    bool isValidBST(TreeNode* root) {
        lint maxm=INT_MAX, minm=INT_MIN;
        maxm++, minm--;
        return helper(root, minm, maxm);
    }
};