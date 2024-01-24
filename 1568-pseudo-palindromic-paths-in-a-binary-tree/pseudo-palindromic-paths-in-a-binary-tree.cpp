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
    int helper(TreeNode* root, vector<int> &count, int &single){
        int ans=0;
        count[root->val]++;
        if(count[root->val]%2) ++single;
        else --single;
        if(root->left==NULL && root->right==NULL){
            ans=single<2?1:0;
        }
        else if(root->left==NULL){
            ans= helper(root->right, count, single);
        }
        else if(root->right==NULL){
            ans= helper(root->left, count, single);
        }
        else{
            ans= helper(root->right, count, single)+
                helper(root->left, count, single);
        }
        count[root->val]--;
        if(count[root->val]%2) ++single;
        else --single;
        return ans;
    }
    int pseudoPalindromicPaths (TreeNode* root) {
        vector<int> count(10);
        int single=0;
        return helper(root, count, single);
    }
};