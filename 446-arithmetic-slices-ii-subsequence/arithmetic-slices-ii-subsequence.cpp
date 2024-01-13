class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n=(int)nums.size(), ans=0;
        unordered_map<int,int> ump[n];
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                long diff=(long)nums[i]-(long)nums[j];
                if(diff<=(long)INT_MIN || diff>=(long)INT_MAX) continue;
                int cdiff= (int)diff;
                if(ump[j].find(cdiff)==ump[j].end()){
                    ump[j][cdiff]=0;
                }
                if(ump[i].find(cdiff)==ump[i].end()){
                    ump[i][cdiff]=0;
                }
                ans+=ump[j][cdiff];
                ump[i][cdiff]+=1+ump[j][cdiff];
            }
        }
        return ans;
    }
};