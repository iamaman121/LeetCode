class Solution {
    private boolean isValidSudokuUtil(char[][] board, int row, int col, int[] freq){
        char ch = board[row][col];
        if(ch=='.') return true;
        freq[ch-'1']++;
        if(freq[ch-'1']>1) return false;
        else return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int[] freq = new int[9];
        for(int row=0;row<9;row++){
            Arrays.fill(freq, 0);
            for(int col=0;col<9;col++){
                if(isValidSudokuUtil(board, row, col, freq)==false) return false;
            }
        }
        for(int col=0;col<9;col++){
            Arrays.fill(freq, 0);
            for(int row=0;row<9;row++){
                if(isValidSudokuUtil(board, row, col, freq)==false) return false;
            }
        }
        for(int r=0;r<9;r+=3){
            for(int c=0;c<9;c+=3){
                Arrays.fill(freq, 0);
                for(int row=r;row<r+3;row++){
                    for(int col=c;col<c+3;col++){
                        if(isValidSudokuUtil(board, row, col, freq)==false) return false;
                    }
                }
            }
        }
        return true;
    }
}
