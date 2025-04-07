class Solution {
    public int rob(int[] nums) {
        int n= nums.length, ans=0;
        if(n==1) return nums[0];
        int[] dp= new int[n];
        dp[0]= nums[0]; dp[1]= Math.max(nums[1],nums[0]);
        for(int i=2;i<=n-2;i++){
            dp[i]= dp[i-2]+nums[i];
            if(dp[i]<dp[i-1]) dp[i]= dp[i-1];
        }
        ans= dp[n-2];
        dp= new int[n];
        dp[1]=nums[1];
        for(int i=2;i<=n-1;i++){
            dp[i]= dp[i-2]+nums[i];
            if(dp[i]<dp[i-1]) dp[i]= dp[i-1];
        }
        return Math.max(ans, dp[n-1]);
    }
}