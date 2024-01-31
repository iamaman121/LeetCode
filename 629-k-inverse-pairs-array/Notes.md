<h2>k-inverse-pairs-array Notes</h2><hr>class Solution {
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
        int dp[2][k+1];
        memset(dp,0,sizeof(dp));
        dp[0][0]=1;
        for(int j=1;j<=n;++j){
            int r=j%2, csum=0;
            for(int i=0;i<=k;++i){
                csum=(csum+dp[1-r][i])%mod;
                if(i-j>=0) csum = (csum-dp[1-r][i-j]+mod)%mod;
                dp[r][i]= csum;
            }
        } 
        return dp[n%2][k];
    }
};