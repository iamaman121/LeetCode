class Solution {
public:
    int numRescueBoats(vector<int>& wt, int limit) {
        int minNumBoats=0;
        sort(wt.begin(), wt.end());
        int beg=0, end=(int)wt.size()-1;
        while(beg<end){
            if(wt[beg]+wt[end]<=limit){
                ++beg;
            }
            ++minNumBoats;
            --end;
        }
        if(beg==end) ++minNumBoats;
        return minNumBoats;
    }
};