class Solution {
    public void setZeroes(int[][] matrix) {
        int r= matrix.length, c= matrix[0].length;
        boolean setRowZero= false;
        for(int i=0;i<c;i++){
            if(matrix[0][i]==0){
                setRowZero= true;
                break;
            }
        }
        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]= 0;
                    matrix[0][j]= 0;
                }
            }
        }
        for(int i=r-1;i>0;i--){
            for(int j=c-1;j>=0;j--){
                if(matrix[i][j]==0) continue;
                else if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]= 0;
            }
        }
        if(setRowZero){
            for(int i=0;i<c;i++) matrix[0][i]= 0;
        }
    }
}