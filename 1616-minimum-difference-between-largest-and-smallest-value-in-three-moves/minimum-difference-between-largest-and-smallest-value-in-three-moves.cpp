class Solution {
public:
    int minDifference(vector<int>& nums) {
        int n= (int)nums.size();
        if(n<=4) return 0;
        sort(nums.begin(),nums.end());
        int minm= nums[n-1]-nums[3];
        minm= min(minm, nums[n-2]-nums[2]);
        minm= min(minm, nums[n-3]-nums[1]);
        minm= min(minm, nums[n-4]-nums[0]);
        return minm;
    }
};