
// bool cmp(char a, char b){
//     return ump[a]<ump[b];
// }
class Solution {
public:
    
    string customSortString(string order, string s) {
        unordered_map<char,int> ump;
        for(int i=0;i<(int)order.length();++i){
            ump[order[i]]= i+1;
        }
        sort(s.begin(), s.end(), [&](char a, char b) {return ump[a]<ump[b]; });
        return s;
    }
};