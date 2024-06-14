class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        ArrayList<int[]> mergedNonOverlappingIntervals= new ArrayList<>();
        int len= 0, n=intervals.length;
        for(int i=0;i<n;++i){
            if(len==0 || 
                mergedNonOverlappingIntervals.get(len-1)[1]<intervals[i][0]){
                mergedNonOverlappingIntervals.add(intervals[i]);
                ++len;
            }
            else{
                mergedNonOverlappingIntervals.get(len-1)[1]= 
                    Math.max(mergedNonOverlappingIntervals.get(len-1)[1], intervals[i][1]);
            }
        }
        return mergedNonOverlappingIntervals.toArray(new int[len][]);
    }
}