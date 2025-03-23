class Solution {
    boolean[] s= new boolean[101];
    private boolean intersect(int[][] prop, int i, int j, int k){
        for(int a=0;a<=100;a++) s[a]=false;
        for(int v: prop[i]) s[v]=true;
        int count=0;
        for(int v: prop[j]){
            if(s[v]){
                s[v]=false;
                count++;
                if(count==k) return true;
            }
        }
        return false;
    }
    public int numberOfComponents(int[][] prop, int k) {
        int n= prop.length, m= prop[0].length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(intersect(prop, i, j, k)){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis= new boolean[n];
        int ncc=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                ncc++;
            }
        }
        return ncc;
    }
    private void dfs(int s, List<List<Integer>> adj, boolean[] vis){
        vis[s]= true;
        for(int d:adj.get(s)){
            if(!vis[d]){
                dfs(d, adj, vis);
            }
        }
        return;
    }
}