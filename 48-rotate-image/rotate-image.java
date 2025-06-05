class Solution {
    private void swap(int[][] matrix, int row1, int col1, int row2, int col2){
        int temp= matrix[row1][col1];
        matrix[row1][col1]= matrix[row2][col2];
        matrix[row2][col2]= temp;
    }
    private void swap(int[][] matrix, int row, int col1, int col2){
        int temp= matrix[row][col1];
        matrix[row][col1]= matrix[row][col2];
        matrix[row][col2]= temp;
    }
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int leftCol= 0, rightCol= n-1;
        while(leftCol<rightCol){
            for(int r=0;r<n;r++){
                swap(matrix, r, leftCol, rightCol);
            }
            leftCol++; rightCol--;
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                swap(matrix, i, j, n-1-j, n-1-i);
            }
        }
    }
}