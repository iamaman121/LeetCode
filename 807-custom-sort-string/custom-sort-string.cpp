unordered_map<char,int> ump;
bool cmp(char a, char b){
    return ump[a]<ump[b];
    return a<b;
}
class Solution {
public:
    
    string customSortString(string order, string s) {
        ump.clear();
        for(int i=0;i<(int)order.length();++i){
            ump[order[i]]= i+1;
        }
        sort(s.begin(), s.end(), cmp);
        return s;
    }
};