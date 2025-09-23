class Solution {
    private int uniquePathsWithObstaclesUtil(int[][] grid, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(grid[i][j]==1) return 0;
        if(dp[i][j]==-1){
            dp[i][j]= uniquePathsWithObstaclesUtil(grid, i-1, j, dp) +
                        uniquePathsWithObstaclesUtil(grid, i, j-1, dp);
        }
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1) return 0;
        int n= grid.length, m= grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsWithObstaclesUtil(grid, n-1, m-1, dp);
    }
}