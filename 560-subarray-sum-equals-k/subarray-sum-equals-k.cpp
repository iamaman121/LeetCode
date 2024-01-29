class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int ans=0,csum=0;
        map<int,int> mp;
        int n=(int)nums.size();
        for(int i=0;i<n;++i){
            csum+=nums[i];
            if(mp.find(csum-k)!=mp.end()){
                ans+=mp[csum-k];
            }
            if(csum==k) ++ans;
            mp[csum]++;
        }
        return ans;
    }
};