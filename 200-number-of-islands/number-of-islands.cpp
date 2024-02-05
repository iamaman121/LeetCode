class Solution {
public:
    vector<int> dir= vector<int>({-1,0,1,0,-1});
    void dfs(int r, int c, vector<vector<char>>& grid, vector<vector<bool>> &vis, int m, int n){
        vis[r][c]=true;
        for(int i=0;i<4;++i){
            int nr=r+dir[i], nc=c+dir[i+1];
            if(nr<0 || nc<0 || nr==m || nc==n || grid[nr][nc]=='0' || vis[nr][nc]) continue;
            dfs(nr, nc, grid, vis, m ,n);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int m= (int)grid.size(), n=(int)grid[0].size();
        vector<vector<bool>> vis(m, vector<bool>(n));
        int islands=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i, j, grid, vis, m, n);
                    ++islands;
                }
            }
        }
        return islands;
    }
};