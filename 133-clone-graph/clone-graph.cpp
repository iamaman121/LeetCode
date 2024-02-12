/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    unordered_map<Node*,Node*> ump;
    Node* getClone(Node* node){
        if(ump.find(node)==ump.end()){
            ump[node] = new Node(node->val);
        }
        return ump[node];
    }
    unordered_set<Node*> vis;
    void dfs(Node* src){
        vis.insert(src);
        Node *clone= getClone(src);
        for(Node* des: src->neighbors){
            clone->neighbors.push_back(getClone(des));
            if(vis.find(des)==vis.end()){
                dfs(des);
            }
        }
    }
    Node* cloneGraph(Node* node) {
        if(!node) return node;
        dfs(node);
        return getClone(node);
    }
};