class Solution {
    int n,m;
    boolean[][] A,P;
    int dir[]= {0,-1,0,1,0};
    private boolean isOk(int r, int c){
        return r>=0 && r<n && c>=0 && c<m;
    }
    private void dfs(int[][] ht, int r, int c, boolean[][] vis){
        vis[r][c]= true;
        for(int i=0;i<4;i++){
            int nr= r+dir[i], nc= c+dir[i+1];
            if(isOk(nr, nc) && ht[nr][nc]>=ht[r][c] && !vis[nr][nc]){
                // vis[nr][nc]= true;
                dfs(ht, nr, nc, vis);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] ht) {
        n= ht.length; m= ht[0].length;
        A= new boolean[n][m]; P= new boolean[n][m];
        for(int i=0;i<n;i++){
            // A[i][m-1]= true;
            dfs(ht, i, m-1, A);
            // P[i][0]= true;
            dfs(ht, i, 0, P);
        }
        for(int j=0;j<m;j++){
            // A[n-1][j]= true;
            dfs(ht, n-1, j, A);
            // P[0][j]= true;
            dfs(ht, 0, j, P);
        }
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j] && P[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}