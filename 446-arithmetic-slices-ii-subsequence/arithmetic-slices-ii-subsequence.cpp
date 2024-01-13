class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n=(int)nums.size(), ans=0;
        unordered_map<int,int> ump[n];
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                long dif = (long)nums[i]-(long)nums[j];
                if(dif<=(long)INT_MIN || dif>=(long)INT_MAX) continue;
                int diff= (int)dif;
                int apj=0, api=0;
                if(ump[j].find(diff)!=ump[j].end()){
                    apj=ump[j][diff];
                }
                if(ump[i].find(diff)!=ump[i].end()){
                    api=ump[i][diff];
                }
                ans+=apj;
                ump[i][diff]=api+apj+1;
            }
        }
        return ans;
    }
};