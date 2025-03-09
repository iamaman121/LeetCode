class Solution {
    public int carFleet(int target, int[] pos, int[] spd) {
        int n= pos.length;
        int[][] psa= new int[n][2];
        for(int i=0;i<n;i++){
            psa[i][0]= pos[i]; psa[i][1]= spd[i];
        }
        Arrays.sort(psa, (a,b)->b[0]-a[0]);
        Stack<Double> stk = new Stack<>();
        for(int[] p: psa){
            double time= (double)(target-p[0])/p[1];
            if(!stk.isEmpty() && stk.peek()>=time) continue;
            stk.push(time);
        }
        return stk.size();
    }
}