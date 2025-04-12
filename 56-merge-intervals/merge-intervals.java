class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]) return b[1]-a[1];
                else return a[0]-b[0];
            }
        });
        int i=0, j=1, n= intervals.length;
        while(j<n){
            if(intervals[j][0]>intervals[i][1]){
                intervals[++i]= intervals[j];
            }
            else{
                intervals[i][0]= Math.min(intervals[i][0], intervals[j][0]);
                intervals[i][1]= Math.max(intervals[i][1], intervals[j][1]);
            }
            j++;
        }
        int[][] ans= new int[i+1][2];
        for(j=0;j<=i;j++) ans[j]= intervals[j];
        return ans;
    }
}