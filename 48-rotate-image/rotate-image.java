class Solution {
    private void swap(int[][] matrix, int row, int col){
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }
    private void swap(int[][] matrix, int row, int col1, int col2){
        int temp = matrix[row][col1];
        matrix[row][col1] = matrix[row][col2];
        matrix[row][col2] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n<2) return;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                swap(matrix, i, j);
            }
        }
        for(int j=0;j<n/2;j++){
            for(int i=0;i<n;i++){
                swap(matrix, i, j, n-1-j);
            }
        }
    }
}