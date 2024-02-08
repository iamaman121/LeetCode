class Solution {
public:
    int numSquares(int n) {
        vector<int> val;
        for(int i=1;i*i<=n;++i){
            val.push_back(i*i);
        }
        vector<int> dp(n+1,1e9);
        dp[0]=0;
        for(int i=0;i<n;++i){
            if(dp[i]==1e9) continue;
            for(int v: val){
                if(i>n-v) break;
                dp[i+v]=min(dp[i+v],1+dp[i]);
            }
        }
        return dp[n];
    }
};