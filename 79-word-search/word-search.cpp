class Solution {
public:
    vector<int> dir= vector<int>({-1,0,1,0,-1});
    bool dfs(vector<vector<char>>& board, int r, int c, int m, int n, string &word, int idx, vector<vector<bool>> &vis){
        if(idx== word.size()) return true;
        if(r<0 || c<0 || r==m || c==n || word[idx]!=board[r][c] || vis[r][c]) return false;
        vis[r][c]=true;
        for(int i=0;i<4;++i){
            int nr=r+dir[i], nc=c+dir[i+1];
            if(dfs(board, nr, nc, m, n, word, idx+1, vis)) return true;
        }
        vis[r][c]=false;
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        bool ans=false;
        int m= (int)board.size(), n= (int)board[0].size();
        vector<vector<bool>> vis(m, vector<bool> (n));
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(board[i][j]==word[0]){
                    if(dfs(board, i, j, m, n, word, 0, vis)) return true;
                }
            }
        }
        return false;
    }
};