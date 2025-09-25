class Solution {
    private void dfs(int src, int[][] graph, boolean[] vis){
		vis[src]= true;
		for(int des=0;des<graph.length;des++){
			if(graph[src][des]==0 || vis[des]) continue;
			dfs(des, graph, vis);
		}
	}
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis= new boolean[n];
		int count= 0;
		for(int i=0;i<n;i++){
			if(vis[i]) continue;
			count++;
			dfs(i, isConnected, vis);
		}
		return count;
    }
}