class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n= grid.length, m= grid[0].length, dot= 0, ans=0;
        int[][] diffXY= new int[n][m];
        int[] cntDot= new int[m];
        for(int i=0;i<n;i++){
            dot=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X') diffXY[i][j]=1;
                else if(grid[i][j]=='Y') diffXY[i][j]=-1;
                else{
                    dot++;
                    cntDot[j]+= dot;
                }
                if(i>=1) diffXY[i][j]+=diffXY[i-1][j];
                if(j>=1) diffXY[i][j]+=diffXY[i][j-1];
                if(i>=1 && j>=1) diffXY[i][j]-=diffXY[i-1][j-1];
                if(diffXY[i][j]==0 && (i+1)*(j+1)!=cntDot[j]) ans++;
            }
        }
        return ans;
    }
}