class Solution {
    public int maxDistToClosest(int[] seats) {
        int dist= 0, i= -1, n= seats.length;
        for(int j=0;j<n;j++){
            if(seats[j]==1){
                if(i==-1){
                    dist= Math.max(dist, j);
                }
                else{
                    dist= Math.max(dist, (j-i)/2);
                }
                i= j;
            }
        }
        dist= Math.max(dist, n-1-i);
        return dist;
    }
}