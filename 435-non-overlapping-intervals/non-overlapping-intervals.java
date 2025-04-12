class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]) return b[0]-a[0];
                else return a[1]-b[1];
            }
        });
        // for(int[] tmp: intervals) System.out.print(tmp[0]+" "+tmp[1]+" , ");
        // return 0;
        int i=0, j=1, n= intervals.length, cnt=0;
        while(j<n){
            if(intervals[j][0]>=intervals[i][1]){
                intervals[++i]= intervals[j];
            }
            else cnt++;
            j++;
        }
        return cnt;
    }
}