class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        int ng= (int)g.size(), ns = (int)s.size();
        int i=0, j=0, cnt=0;
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        while(i<ng && j<ns){
            if(g[i]>s[j]){
                ++j;
            }
            else{
                ++cnt;
                ++i;
                ++j;
            }
        }
        return cnt;
    }
};