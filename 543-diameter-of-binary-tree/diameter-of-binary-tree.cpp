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
    int diameterOfBinaryTreeHelper(TreeNode* root, int &diameter){
        if(!root) return 0;
        int lft= diameterOfBinaryTreeHelper(root->left, diameter);
        int rgt= diameterOfBinaryTreeHelper(root->right, diameter);
        diameter= max(diameter, lft+rgt);
        return 1+max(lft, rgt);
    }
    int diameterOfBinaryTree(TreeNode* root) {
        int diameter=0;
        diameterOfBinaryTreeHelper(root, diameter);
        return diameter;
    }
};