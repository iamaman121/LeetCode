class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n= (int)nums.size();
        vector<int> lis(n,1);
        for(int i=1;i<n;++i){
            for(int j=0;j<i;++j){
                if(nums[i]>nums[j]){
                    lis[i]=max(lis[i],1+lis[j]);
                }
            }
        }
        int mlis=0;
        for(int i=0;i<n;++i){
            mlis=max(mlis,lis[i]);
        }
        return mlis;
    }
};