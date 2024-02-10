/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string data= "";
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            data+="#";
            TreeNode* frnt= q.front();
            q.pop();
            if(!frnt) data+="N";
            else{
                data+= to_string(frnt->val);
                q.push(frnt->left);
                q.push(frnt->right);
            }
        }
        cout<<data<<"\n";
        return data;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data[1]=='N'){
            return NULL;
        }
        string temp="";
        int i =1, sz=(int)data.length();
        queue<TreeNode*> q;
        while(i<data.length() && data[i]!='#') temp+=data[i++];
        TreeNode *root= new TreeNode(stoi(temp));
        q.push(root);
        while(!q.empty()){
            TreeNode *frnt= q.front();
            q.pop();
            ++i; temp="";
            while(data[i]!='#') temp+=data[i++];
            if(temp!="N"){
                frnt->left= new TreeNode(stoi(temp));
                q.push(frnt->left);
            }
            else frnt->left=NULL;
            ++i; temp="";
            while(i<data.length() && data[i]!='#') temp+=data[i++];
            if(temp!="N"){
                frnt->right= new TreeNode(stoi(temp));
                q.push(frnt->right);
            }
            else frnt->right=NULL;
        }
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));