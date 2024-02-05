class Solution {
public:
    vector<int> dir= vector<int>({-1,0,1,0,-1});
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& ht) {
        int m= (int)ht.size(), n= (int)ht[0].size();
        int vis[m][n];
        memset(vis, 0, sizeof(vis));
        for(int i=0;i<m;++i){
            vis[i][0]|=1;
            vis[i][n-1]|=2;
        }
        for(int i=0;i<n;++i){
            vis[0][i]|=1;
            vis[m-1][i]|=2;
        }
        queue<vector<int>> q;
        for(int i=0;i<m;++i){
            q.push({i,0,vis[i][0]});
            q.push({i,n-1,vis[i][n-1]});
        }
        for(int i=1;i<=n-2;++i){
            q.push({0,i,vis[0][i]});
            q.push({m-1,i,vis[m-1][i]});
        }
        while(!q.empty()){
            auto v = q.front();
            q.pop();
            int r= v[0], c= v[1], val=v[2];
            for(int i=0;i<4;++i){
                int nr=r+dir[i], nc=c+dir[i+1];
                if(nr<0 || nc<0 || nr==m || nc==n || ht[nr][nc]<ht[r][c] || ((val&vis[nr][nc])==val)) continue;
                vis[nr][nc]|=val;
                q.push({nr, nc, vis[nr][nc]});
            }
        }
        
        vector<vector<int>> res;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(vis[i][j]==3) res.push_back({i,j});
            }
        }
        return res;
    }
};