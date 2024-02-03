class Solution {
public:
    bool wordBreak(string s, vector<string>& dict) {
        int n= (int)s.size();
        vector<bool> dp(n+1,false);
        dp[0]=true;
        for(int i=0;i<n;++i){
            if(!dp[i])  continue;
            for(int j=0;j<(int)dict.size();++j){
                int b=0;
                while(i+b<n && b<dict[j].size() && s[i+b]==dict[j][b]){
                    ++b;
                }
                if(b==dict[j].size()){
                    dp[i+b]=true;
                }
            }
        }
        return dp[n];
    }
};