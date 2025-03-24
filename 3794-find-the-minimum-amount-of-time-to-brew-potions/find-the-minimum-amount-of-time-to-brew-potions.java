class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n= skill.length, m= mana.length;
        long[] time = new long[n];
        long maxTime=0;
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(i>0) time[i]= Math.max(time[i],time[i-1]);
                time[i]+=mana[j]*skill[i];
            }
            maxTime= Math.max(maxTime, time[n-1]);
            if(j==0) continue;
            for(int i=n-2;i>=0;i--){
                time[i]= time[i+1]-skill[i+1]*mana[j];
            }
        }
        return maxTime;
    }
}