class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0, n= intervals.length, siz;
        List<int[]> list = new ArrayList<>();
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(intervals[i++]);
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i<n){
            list.add(intervals[i++]);
        }
        siz= list.size(); i=0;
        int[][] ans= new int[siz][2];
        for(i=0;i<siz;i++) ans[i]= list.get(i);
        return ans;
    }
}