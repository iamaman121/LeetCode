class Solution {
    int MAXM= (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        for(int i=1;i<=amount;i++) dp[i]= MAXM;
        Arrays.sort(coins);
        for(int i=0;i<amount;i++){
            if(dp[i]==MAXM) continue;
            for(int c: coins){
                if(i<=amount-c){
                    dp[i+c]= Math.min(dp[i+c],1+dp[i]);
                }
            }
        }
        return dp[amount]==MAXM?-1:dp[amount];
    }
}