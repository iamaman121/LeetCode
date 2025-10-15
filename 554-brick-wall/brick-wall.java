class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n= wall.size();
        Map<Integer, Integer> store= new HashMap<>();
        for(List<Integer> w: wall){
            int width= 0;
            for(int i=0;i<w.size()-1;i++){
                width+= w.get(i);
                store.put(width, store.getOrDefault(width,0)+1);
            }
        }
        int maxm= 0;
        for(int nob: store.values()){
            maxm= Math.max(maxm, nob);
        }
        return n-maxm;
    }
}