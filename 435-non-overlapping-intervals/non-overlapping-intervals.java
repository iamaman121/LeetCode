class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]) return b[0]-a[0];
                else return a[1]-b[1];
            }
        });
        int i=0, n= intervals.length;
        for(int j=1;j<n;j++){
            if(intervals[j][0]>=intervals[i][1]){
                intervals[++i]= intervals[j];
            }
        }
        return n-1-i;
    }
}