class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int i=0, n= intervals.length;
        for(int j=1;j<n;j++){
            if(intervals[j][0]>=intervals[i][1]){
                intervals[++i]= intervals[j];
            }
        }
        return n-1-i;
    }
}