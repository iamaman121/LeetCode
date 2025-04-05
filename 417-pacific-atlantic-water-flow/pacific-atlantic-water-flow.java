class Solution {
    int n,m;
    int[] dir= {0,-1,0,1,0};
    private boolean ok(int r, int c){
        return r>=0 && r<n && c>=0 && c<m;
    }
    private void dfs(int r, int c, int[][] ht, boolean[][] vis){
        vis[r][c]= true;
        int nr, nc;
        for(int i=0;i<4;i++){
            nr= r+dir[i]; nc=c+dir[i+1];
            if(ok(nr,nc) && !vis[nr][nc] && ht[nr][nc]>=ht[r][c]){
                dfs(nr, nc, ht, vis);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] ht) {
        n= ht.length; m= ht[0].length;
        boolean[][] A= new boolean[n][m];
        boolean[][] P= new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(i, 0, ht, P);
            dfs(i, m-1, ht, A);
        }
        for(int j=0;j<m;j++){
            dfs(0, j, ht, P);
            dfs(n-1, j, ht, A);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j] && P[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
}