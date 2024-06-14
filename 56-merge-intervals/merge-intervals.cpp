class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> mergedNonOverlappingIntervals;
        int len= 0, n=(int)intervals.size();
        for(int i=0;i<n;++i){
            if(len==0 || 
                mergedNonOverlappingIntervals[len-1][1]<intervals[i][0]){
                mergedNonOverlappingIntervals.push_back(intervals[i]);
                ++len;
            }
            else{
                mergedNonOverlappingIntervals[len-1][1]= 
                    max(mergedNonOverlappingIntervals[len-1][1], intervals[i][1]);
            }
        }
        return mergedNonOverlappingIntervals;
    }
};