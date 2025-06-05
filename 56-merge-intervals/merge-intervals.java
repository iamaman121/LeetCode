class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int n= intervals.length, i=0;
        for(int j=1;j<n;j++){
            if(intervals[j][0]<=intervals[i][1]){
                intervals[i][1]= Math.max(intervals[i][1], intervals[j][1]);
            }
            else{
                intervals[++i]= intervals[j];
            }
        }
        int[][] res = new int[i+1][2];
        for(int k=0;k<=i;k++) res[k]= intervals[k];
        return res;
    }
}