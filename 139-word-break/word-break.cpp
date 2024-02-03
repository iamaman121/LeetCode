class Solution {
public:
    bool wordBreak(string s, vector<string>& dict) {
        int n= (int)s.size();
        vector<vector<int>> indexes(n);
        vector<bool> dp(n+1,false);
        dp[0]=true;
        for(int i=0;i<n;++i){
            if(!dp[i])  continue;
            for(int j=0;j<(int)dict.size();++j){
                int a=i, b=0;
                while(a<n && b<dict[j].size() && s[a]==dict[j][b]){
                    ++a, ++b;
                }
                cout<<i<<" "<<b<<"\n";
                if(b==dict[j].size()){
                    dp[i+b]=true;
                }
            }
        }
        return dp[n];
    }
};