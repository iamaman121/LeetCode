class Solution {
public:
    static bool comp(vector<int> a, vector<int> b){
        if(a[1]==b[1]) return a[0]>b[0];
        return a[1]<b[1];
    }
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int ans=0;
        sort(intervals.begin(), intervals.end(), comp);
        for(int i=1; i<(int)intervals.size(); ++i){
            if(intervals[i][0]<intervals[i-1][1]){
                ++ans;
                intervals[i]=intervals[i-1];
            }
        }
        return ans;
    }
};