// https://leetcode.com/problems/set-matrix-zeroes/description/
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return;
        int rows = matrix.length, cols = matrix[0].length;
        boolean isFirstRowZero = false;
        for(int i=0;i<cols;i++){
            if(matrix[0][i]==0){
                isFirstRowZero = true;
                break;
            }
        }
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=rows-1;i>0;i--){
            for(int j=cols-1;j>=0;j--){
                if(matrix[i][j]==0) continue;
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        if(isFirstRowZero){
            for(int i=0;i<cols;i++){
                matrix[0][i]=0;
            }
        }
    }
}