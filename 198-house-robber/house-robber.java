class Solution {
    public int rob(int[] arr) {
        int n= arr.length;
        if(n==1) return arr[0];
        else if(n==2) return Math.max(arr[0],arr[1]);
        int[] dp= new int[n];
        dp[0]= arr[0]; dp[1]= Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dp[i]= Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}