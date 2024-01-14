class Solution {
public:
    int maxLengthBetweenEqualCharacters(string s) {
        int ans=-1, n=(int)s.length();
        vector<int> alp(26,-1);
        for(int i=0;i<n;++i){
            if(alp[s[i]-'a']==-1){
                alp[s[i]-'a']=i;
            }
            else{
                ans=max(ans,i-alp[s[i]-'a']-1);
            }
        }
        return ans;
    }
};