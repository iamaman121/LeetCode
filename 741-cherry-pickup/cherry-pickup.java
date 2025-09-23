class Solution {
    private int cherryPickUpUtil(int r1, int c1, int r2, int[][] grid, int[][][] dp){
        int c2= r1+c1-r2;
        if(r1<0 || c1<0 || r2<0 || c2<0 || grid[r1][c1]==-1 || grid[r2][c2]==-1) return (int)-1e9;
        if(r1==0 && c1==0 && r2==0 && c2==0) return grid[r1][c1];
        if(dp[r1][c1][r2]==-1){
            int w= cherryPickUpUtil(r1-1, c1, r2-1, grid, dp);
            int x= cherryPickUpUtil(r1, c1-1, r2, grid, dp);
            int y= cherryPickUpUtil(r1-1, c1, r2, grid, dp);
            int z= cherryPickUpUtil(r1, c1-1, r2-1, grid, dp);
            int ans= Math.max(Math.max(w,x), Math.max(y,z)) + grid[r1][c1];
            if(r1!=r2 || c1!=c2) ans+= grid[r2][c2];
            dp[r1][c1][r2]= ans;
        }
        return dp[r1][c1][r2];
    }
    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int[][][] dp = new int[n][n][n];
        for(int j=0;j<n;j++){
            for(int k=0;k<n;k++){
                Arrays.fill(dp[j][k], -1);
            }
        }
        int ans= cherryPickUpUtil(n-1, n-1, n-1, grid, dp);
        return ans>0?ans:0;
    }
}