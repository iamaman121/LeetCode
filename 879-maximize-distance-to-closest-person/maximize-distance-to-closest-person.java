class Solution {
    public int maxDistToClosest(int[] seats) {
        int n= seats.length;
        List<Integer> indexes= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                indexes.add(i);
            }
        }
        int maxm= indexes.get(0)-0;
        for(int i=1;i<indexes.size();i++){
            maxm= Math.max(maxm, (indexes.get(i)-indexes.get(i-1))/2);
        }
        maxm= Math.max(maxm, n-1-indexes.get(indexes.size()-1));
        return maxm;
    }
}