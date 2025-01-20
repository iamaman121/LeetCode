class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int csum = nums[0], msum = nums[0];
        for(int i=1;i<(int)nums.size();i++){
            csum = max(csum+nums[i], nums[i]);
            msum = max(csum, msum);
        }
        return msum;
    }
};