class Solution {
    public int[] minCosts(int[] cost) {
        int prev= 101;
        for(int i=0;i<cost.length;i++){
            if(cost[i]<prev){
                prev= cost[i];
            }
            else cost[i]= prev;
        }
        return cost;
    }
}