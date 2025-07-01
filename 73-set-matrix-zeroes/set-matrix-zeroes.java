class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isRowZero = false;
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                isRowZero = true;
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=m-1;i>0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]==0) continue;
                else if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        if(isRowZero){
            for(int i=0;i<n;i++){
                matrix[0][i]= 0;
            }
        }
    }
}