class Solution {
public:
    int findCenter(vector<vector<int>>& edges) {
        set<int> st;
        for(auto edge: edges){
            if(st.count(edge[0])) return edge[0];
            else st.insert(edge[0]);
            if(st.count(edge[1])) return edge[1];
            else st.insert(edge[1]);
        }
        return -1;
    }
};