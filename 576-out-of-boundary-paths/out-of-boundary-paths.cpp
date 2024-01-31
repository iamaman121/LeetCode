class Solution {
public:
    int mod=1e9+7;
    int dp[51][51][51];
    int dfs(int m, int n, int remMove, int cR, int cC){
        if(cR<0 || cR==m || cC<0 || cC==n) return 1;
        if(remMove<=0) return 0;
        if(dp[remMove][cR][cC]!=-1) return dp[remMove][cR][cC];
        int ans=0;
        ans=(ans+dfs(m,n,remMove-1,cR-1,cC))%mod;
        ans=(ans+dfs(m,n,remMove-1,cR+1,cC))%mod;
        ans=(ans+dfs(m,n,remMove-1,cR,cC-1))%mod;
        ans=(ans+dfs(m,n,remMove-1,cR,cC+1))%mod;
        return dp[remMove][cR][cC] = ans;
    }
    int findPaths(int m, int n, int maxMove, int sR, int sC) {
        memset(dp,-1,sizeof(dp));
        return dfs(m, n, maxMove, sR, sC);
    }
};