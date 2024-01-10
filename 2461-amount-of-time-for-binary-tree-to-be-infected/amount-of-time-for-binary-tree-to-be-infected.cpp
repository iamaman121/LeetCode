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
    vector<TreeNode*> findNodes(TreeNode*  curr, TreeNode* par){
        vector<TreeNode*> lst;
        if(curr->left!=NULL) lst.push_back(curr->left);
        if(curr->right!=NULL) lst.push_back(curr->right);
        if(par!=NULL) lst.push_back(par);
        return lst;
    }
    int findInfectionTime(TreeNode*  curr, unordered_map<TreeNode* , TreeNode*> &ump, unordered_set<TreeNode*> &us){
        if(curr==NULL) return 0;
        us.insert(curr);
        int maxm=0;
        TreeNode* par = NULL;
        if(ump.find(curr)!=ump.end()) par=ump[curr];
        for(TreeNode* a: findNodes(curr,par)){
            if(us.find(a)==us.end()) maxm=max(maxm, 1+findInfectionTime(a,ump,us));
        }
        return maxm;
    }
    void traverse(TreeNode* root, TreeNode* par, unordered_map<TreeNode* , TreeNode*> &ump, TreeNode* &curr, int start){
        if(root==NULL) return;
        ump.insert({root, par});
        if(root->val == start) curr=root;
        traverse(root->left, root, ump, curr, start);
        traverse(root->right, root, ump, curr, start);
    }
    int amountOfTime(TreeNode* root, int start) {
        unordered_map<TreeNode* , TreeNode*> ump;
        unordered_set<TreeNode*> us;
        TreeNode* curr = NULL;
        traverse(root, NULL, ump, curr, start);
        return findInfectionTime(curr, ump, us);
    }
};