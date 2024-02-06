class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string,vector<string>> ump;
        string alp;
        for(string str: strs){
            alp=str;
            sort(alp.begin(),alp.end());
            ump[alp].push_back(str);
        }
        vector<vector<string>> res;
        for(auto v:ump){
            res.push_back(v.second);
        }
        return res;
    }
};