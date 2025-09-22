class Solution {
    private int numSquaresUtil(int n, int[] dp){
        if(n==0 || n==1) return n;
        if(dp[n]==-1){
            int smallest= n;
            for(int i=1;i*i<=n;i++){
                smallest= Math.min(smallest, numSquaresUtil(n-i*i, dp));
            }
            dp[n]= 1+smallest;
        }
        return dp[n];
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return numSquaresUtil(n, dp);
    }
}