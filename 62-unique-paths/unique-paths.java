class Solution {
    private int uniquePathsUtil(int i, int j, int[][] dp){
        if(i==0 || j==0) return 1;
        if(dp[i][j]==-1){
            dp[i][j]= uniquePathsUtil(i-1, j, dp) + uniquePathsUtil(i, j-1, dp);
        }
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsUtil(m-1, n-1, dp);
    }
}