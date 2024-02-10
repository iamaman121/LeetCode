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
    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int bp, int ep, int bi, int ei){
        if(bp>ep) return NULL;
        int rVal=preorder[bp];
        int idx=bi;
        while(inorder[idx]!=rVal) ++idx;
        int lft=idx-bi;
        TreeNode *root= new TreeNode(rVal);
        root->left=helper(preorder, inorder, bp+1, bp+lft, bi, bi+lft-1);
        root->right=helper(preorder, inorder, bp+lft+1, ep, bi+lft+1, ei);
        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size()==0) return NULL;
        return helper(preorder, inorder, 0, (int)preorder.size()-1, 0, (int)inorder.size()-1);
    }
};