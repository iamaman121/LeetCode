class Solution {
public:
    bool dfs(int s, vector<vector<int>>& adj, vector<int> &vis){
        vis[s]=1;
        int ans=true;
        for(int d:adj[s]){
            if(!vis[d]){
                ans = ans && dfs(d, adj, vis);
            }
            else if(vis[d]==1) return false;
        }
        vis[s]=2;
        return ans;
    }
    bool canFinish(int n, vector<vector<int>>& preq) {
        vector<vector<int>> adj(n);
        for(auto v: preq){
            adj[v[0]].push_back(v[1]);
        }
        vector<int> vis(n);
        for(int i=0;i<n;++i){
            if(!vis[i]){
                if(!dfs(i, adj, vis)) return false;
            }
        }
        return true;
    }
};