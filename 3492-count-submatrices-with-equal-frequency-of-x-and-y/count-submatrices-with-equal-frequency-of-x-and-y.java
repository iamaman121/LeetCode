class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n= grid.length, m= grid[0].length;
        int[][] cumFreqX= new int[n][m];
        int[][] cumFreqY= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    cumFreqX[i][j]= 1;
                }
                else if(grid[i][j]=='Y'){
                    cumFreqY[i][j]= 1;
                }
            }
        } 
        int ans=0;
        for(int i=1;i<n;i++){
            cumFreqX[i][0]+= cumFreqX[i-1][0];
            cumFreqY[i][0]+= cumFreqY[i-1][0];
        }
        for(int j=1;j<m;j++){
            cumFreqX[0][j]+= cumFreqX[0][j-1];
            cumFreqY[0][j]+= cumFreqY[0][j-1];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                cumFreqX[i][j]+= cumFreqX[i-1][j]+cumFreqX[i][j-1]-cumFreqX[i-1][j-1];
                cumFreqY[i][j]+= cumFreqY[i-1][j]+cumFreqY[i][j-1]-cumFreqY[i-1][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cumFreqY[i][j]==cumFreqX[i][j] && cumFreqX[i][j]>0) ans++;
            }
        }
        return ans;
    }
}