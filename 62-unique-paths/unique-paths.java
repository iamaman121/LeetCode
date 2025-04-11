class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[2][n];
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i%2][j]=dp[i%2][j-1]+dp[1-i%2][j];
            }
        }
        return dp[(m-1)%2][n-1];
    }
}