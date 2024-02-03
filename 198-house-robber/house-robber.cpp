class Solution {
public:
    int rob(vector<int>& nums) {
        int n= (int)nums.size();
        vector<int> dp(n+1);
        dp[1]=nums[0];
        for(int i=2;i<=n;++i){
            dp[i]=max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
};