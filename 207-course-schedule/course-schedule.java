class Solution {
    private boolean dfs(int s, List<List<Integer>> adj, int[] vis){
        System.out.println(s);
        vis[s]= 1;
        for(int d: adj.get(s)){
            if(vis[d]==2) continue;
            if(vis[d]==1 || !dfs(d, adj, vis)) return false;
        }
        vis[s]=2;
        return true;
    }
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] vis= new int[n];
        for(int[] pr: prereq){
            adj.get(pr[0]).add(pr[1]);
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0 && !dfs(i, adj, vis)){
                return false;
            }
        }
        return true;
    }
}