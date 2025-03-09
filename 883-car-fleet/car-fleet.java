class Solution {
    public int carFleet(int target, int[] pos, int[] spd) {
        int n= pos.length;
        int[][] psa= new int[n][2];
        for(int i=0;i<n;i++){
            psa[i][0]= pos[i]; psa[i][1]= spd[i];
        }
        Arrays.sort(psa, (a,b)->b[0]-a[0]);
        double cTime= (double)(target-psa[0][0])/psa[0][1];
        int fleet=1;
        for(int i=1;i<n;i++){
            double time= (double)(target-psa[i][0])/psa[i][1];
            if(time<=cTime) continue;
            else{
                cTime= time;
                ++fleet;
            }
        }        
        return fleet;
    }
}