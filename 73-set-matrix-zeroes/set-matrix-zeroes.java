class Solution {
    public void setZeroes(int[][] matrix) {
        int numRow= matrix.length, numCol= matrix[0].length;
        boolean isFirstRowZero= false;
        for(int j=0;j<numCol;j++){
            if(matrix[0][j]==0){
                isFirstRowZero= true;
                break; // no need to iterate further
            }
        }
        for(int i=1;i<numRow;i++){
            for(int j=0;j<numCol;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]= 0;
                    matrix[0][j]= 0;
                }
            }
        }
        for(int i=numRow-1;i>0;i--){
            for(int j=numCol-1;j>=0;j--){
                if(matrix[i][j]==0) continue;
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(isFirstRowZero){
            for(int j=0;j<numCol;j++){
                matrix[0][j]= 0;
            }
        }
    }
}