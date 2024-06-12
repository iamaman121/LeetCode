class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maximumSubArraySum= -1e9, currSubArraySum= 0;
        for(int i=0;i<(int)nums.size();++i){
            currSubArraySum>0?currSubArraySum+=nums[i]:currSubArraySum=nums[i];
            maximumSubArraySum= max(maximumSubArraySum, currSubArraySum);
        }
        return maximumSubArraySum;
    }
};