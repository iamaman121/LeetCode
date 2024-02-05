class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> alp(26,-2);
        for(int i=0;i<(int)s.size();++i){
            if(alp[s[i]-'a']==-2) alp[s[i]-'a']=i;
            else alp[s[i]-'a']=-1;
        }
        for(int i=0;i<(int)s.size();++i){
            if(alp[s[i]-'a']>=0) return i;
        }
        return -1;
    }
};