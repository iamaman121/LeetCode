class Solution {
public:
    int helper(int pos, int &len, vector<int>& arr, int &k, vector<int> &dp){
        if(pos==len) return 0;
        int maxm=0;
        if(dp[pos]!=-1) return dp[pos];
        
        for(int i=pos;i<min(pos+k,len);++i){
            maxm=max(maxm, arr[i]);
            dp[pos]=max(dp[pos],maxm*(i-pos+1)+helper(i+1, len, arr, k, dp));
        }
        return dp[pos];
    }
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n= (int)arr.size();
        vector<int> dp(n+1,-1);
        // vector<vector<int>> dp(n+1, vector<int> (k+1,-1));
        return helper(0, n, arr, k, dp);
    }
};