class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] A) {
        int n= A.length, m= A[0].length;
        mat= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]= A[i][j];
            }
        }
        for(int i=1;i<n;i++) mat[i][0]+=mat[i-1][0];
        for(int j=1;j<m;j++) mat[0][j]+=mat[0][j-1];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                mat[i][j]+=mat[i][j-1]+mat[i-1][j]-mat[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans= mat[row2][col2];
        ans-=row1>=1?mat[row1-1][col2]:0;
        ans-=col1>=1?mat[row2][col1-1]:0;
        ans+=(row1>=1 && col1>=1)?mat[row1-1][col1-1]:0;
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */