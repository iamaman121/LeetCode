class Solution {
    int n,m;
    int[] dir= {0,-1,0,1,0};
    private boolean ok(int r, int c){
        return r>=0 && r<n && c>=0 && c<m;
    }
    private void dfs(int r, int c, int[][] ht, int[][] vis, int bit){
        vis[r][c]|= bit;
        int nr, nc;
        for(int i=0;i<4;i++){
            nr= r+dir[i]; nc=c+dir[i+1];
            if(ok(nr,nc) && (vis[nr][nc]&bit)==0 && ht[nr][nc]>=ht[r][c]){
                dfs(nr, nc, ht, vis, bit);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] ht) {
        n= ht.length; m= ht[0].length;
        int[][] vis= new int[n][m];
        for(int i=0;i<n;i++){
            dfs(i, 0, ht, vis, 1);
            dfs(i, m-1, ht, vis, 2);
        }
        for(int j=0;j<m;j++){
            dfs(0, j, ht, vis, 1);
            dfs(n-1, j, ht, vis, 2);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==3) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
}