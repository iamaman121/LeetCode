class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        for(int i=1;i<=amount;i++) dp[i]= amount+1;
        for(int i=1;i<=amount;i++){
            for(int c: coins){
                if(i>=c && dp[i-c]<=amount){
                    dp[i]= Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        return dp[amount]<=amount?dp[amount]:-1;
    }
}