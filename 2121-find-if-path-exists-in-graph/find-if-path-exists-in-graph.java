class Solution {
    private List<List<Integer>> constructGraph(int n, int m, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    private boolean checkPath(int n, List<List<Integer>> graph, int src, int des){
        boolean[] vis= new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.add(src); vis[src]= true;
        while(!q.isEmpty()){
            int rem= q.remove();
            for(int d: graph.get(rem)){
                if(vis[d]) continue;
                q.add(d); vis[d]= true;
            }
        }
        return vis[des];
    }
    public boolean validPath(int n, int[][] edges, int src, int des) {
        int m= edges.length;
        List<List<Integer>> graph = constructGraph(n, m, edges);
        return checkPath(n, graph, src, des);
    }
}