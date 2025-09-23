class Solution {
    private static int minPathSumUtil(int[][] grid, int i, int j, int[][] dp){
		if(i<0 || j<0) return (int)1e9;
        if(i==0 && j==0) return grid[i][j];
        if(dp[i][j]==-1){
            dp[i][j]= grid[i][j] + Math.min(minPathSumUtil(grid, i-1, j, dp), minPathSumUtil(grid, i, j-1, dp));
        }
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return minPathSumUtil(grid, n-1, m-1, dp);
    }
}