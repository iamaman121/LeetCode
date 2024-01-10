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
    int maxDistance=0;
public:
    int helper(TreeNode* root, int start){
        int depth=0;
        if(root == NULL){
            return 0;
        }
        int ldepth= helper(root->left, start);
        int rdepth= helper(root->right, start);
        
        if(root->val == start){
            maxDistance= max(ldepth, rdepth);
            depth=-1;
        }
        else if(ldepth>=0 && rdepth>=0){
             depth= max(ldepth, rdepth) + 1;
        }
        else{
            int distance = abs(ldepth) + abs(rdepth);
            maxDistance = max(maxDistance, distance);
            depth= min(ldepth,rdepth) - 1;
        }
        return depth;
    }
    int amountOfTime(TreeNode* root, int start) {
        helper(root, start);
        return maxDistance;
    }
};