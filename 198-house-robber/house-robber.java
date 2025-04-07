class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n];
        dp[0]= nums[0];
        for(int i=1;i<n;i++){
            dp[i]= nums[i]+(i>=2?dp[i-2]:0);
            if(dp[i]<dp[i-1]) dp[i]= dp[i-1];
        }
        return dp[n-1];
    }
}