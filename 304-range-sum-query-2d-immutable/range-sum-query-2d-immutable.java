class NumMatrix {
    int[][] A;
    public NumMatrix(int[][] matrix) {
        int n= matrix.length, m= matrix[0].length;
        A= new int[n][m];
        A[0][0]= matrix[0][0];
        for(int j=1;j<m;j++) A[0][j]=matrix[0][j]+A[0][j-1];
        for(int i=1;i<n;i++) A[i][0]=matrix[i][0]+A[i-1][0];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                A[i][j]=A[i-1][j]+A[i][j-1]-A[i-1][j-1]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans= A[row2][col2];
        if(row1>0) ans-=A[row1-1][col2];
        if(col1>0) ans-=A[row2][col1-1];
        if(row1>0 && col1>0) ans+=A[row1-1][col1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */