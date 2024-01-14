class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int cnt=1, n=(int)nums.size(), maxm=1;
        for(int i=1;i<n;++i){
            if(nums[i]==nums[i-1]) ++cnt;
            else cnt=1;
            if(cnt>maxm) maxm=cnt;
        }
        vector<vector<int>> ans(maxm);
        int prev=nums[0], cidx=0;
        for(int i=0;i<n;++i){
            if(nums[i]==prev){
                ans[cidx++].push_back(nums[i]);
            }
            else{
                cidx=0; prev=nums[i];
                ans[cidx++].push_back(nums[i]);
            }
        }
        return ans;
    }
};