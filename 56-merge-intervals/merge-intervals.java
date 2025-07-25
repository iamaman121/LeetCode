class Solution {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]); 
        //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int mergedIdx= 0;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=intervals[mergedIdx][1]){
                intervals[mergedIdx][1]= Math.max(intervals[mergedIdx][1], intervals[i][1]);
            }
            else{
                intervals[++mergedIdx] = intervals[i];
            }
        }
        int[][] mergedIntervals = new int[mergedIdx+1][2];
        for(int i=0;i<=mergedIdx;i++) mergedIntervals[i] = intervals[i];
        return mergedIntervals;
    }
}