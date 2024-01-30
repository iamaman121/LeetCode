class Solution {
public:
    int mod = 1000000007;
    int dp[1001][1001];
    int helper(int n, int k){
        if(k==0) return 1;
        else if(k<0) return 0;
        else if(n==1) return 0;
        else if(dp[n][k]!=-1) return dp[n][k];
        dp[n][k]=0;
        for(int i=1;i<=min(n,k+1);++i){
            dp[n][k]= (dp[n][k] + helper(n-1, k-i+1))%mod;
        }
        return dp[n][k];
    }
    int kInversePairs(int n, int k) {
        memset(dp, -1, sizeof(dp));
        return helper(n, k);
    }
};