class Solution {
    int[] dir= {-1,0,1,0,-1};
    private boolean check(char[][] board, int r, int c, String word, int pos, boolean used[][]){
        if(r<0 || c<0 || r==board.length || c==board[0].length || used[r][c]) return false;
        if(board[r][c]==word.charAt(pos)){
            if(pos==word.length()-1) return true;
            used[r][c]= true;
            boolean ans= false;
            for(int i=0;i<4;i++){
                if(check(board, r+dir[i], c+dir[i+1], word, pos+1, used)){
                    ans= true;
                    break;
                }
            }
            used[r][c]= false;
            return ans;
        }
        else return false;
    }
    public boolean exist(char[][] board, String word) {
        int n= board.length, m= board[0].length;
        boolean used[][]= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && check(board, i, j, word, 0, used)){
                    return true;
                }
            }
        }
        return false;
    }
}