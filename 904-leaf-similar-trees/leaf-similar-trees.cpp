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
    bool isLeaf(TreeNode* root1){
        return root1!= NULL and root1->left== NULL and root1->right== NULL;
    }
    void dfs(TreeNode* root, vector<int> &leafs){
        if(root == NULL) return;
        if(isLeaf(root)) leafs.push_back(root->val);
        else{
            dfs(root->left, leafs);
            dfs(root->right, leafs);
        }
        return;
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> leafs1;
        vector<int> leafs2;
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        return leafs1 == leafs2;
    }
};