class Solution {
    private List<List<Integer>> constructGraph(int n, int[][] prereq){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge: prereq){
            int v= edge[0], u= edge[1];
            graph.get(u).add(v);
        }
        return graph;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph= constructGraph(n, prerequisites);
        int[] indeg = new int[n];
        for(int s=0;s<n;s++){
            for(int d: graph.get(s)){
                indeg[d]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int s=0;s<n;s++){
            if(indeg[s]==0) q.add(s);
        }
        int count=0;
        while(!q.isEmpty()){
            int s= q.remove();
            count++;
            for(int d: graph.get(s)){
                indeg[d]--;
                if(indeg[d]==0){
                    q.add(d);
                }
            }
        }
        return count==n;
    }
}