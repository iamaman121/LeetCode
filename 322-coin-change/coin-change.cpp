class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, 1e9);
        dp[0]=0;
        for(int i=0;i<amount;++i){
            if(dp[i]==1e9) continue;
            for(int c:coins){
                if(i<=amount-c)dp[i+c]=min(dp[i+c],1+dp[i]);
            }
        }
        return dp[amount]!=1e9?dp[amount]:-1;
    }
};