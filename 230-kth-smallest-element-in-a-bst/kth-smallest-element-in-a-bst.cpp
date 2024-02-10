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
    unordered_map<TreeNode*, int> ump;
    int totalNodes(TreeNode* root){
        if(!root) return 0;
        if(ump.find(root)!=ump.end()) return ump[root];
        return ump[root]= 1+totalNodes(root->left)+totalNodes(root->right);
    }
    int kthSmallest(TreeNode* root, int k) {
        int lft= totalNodes(root->left);
        if(lft>=k) return kthSmallest(root->left, k);
        k-=lft;
        if(k==1) return root->val;
        return kthSmallest(root->right, k-1);
    }
};