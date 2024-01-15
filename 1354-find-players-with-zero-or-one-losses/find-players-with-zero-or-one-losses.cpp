class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_map<int,int> win,los;
        for(auto v:matches){
            win[v[0]]++;
            los[v[1]]++;
        }
        vector<vector<int>> ans(2);
        for(auto v:win){
            int player=v.first;
            if(los.find(player)==los.end()){
                ans[0].push_back(player);
            }
        }
        for(auto v:los){
            if(v.second==1){
                ans[1].push_back(v.first);
            }
        }
        sort(ans[0].begin(),ans[0].end());
        sort(ans[1].begin(),ans[1].end());
        return ans;
    }
};