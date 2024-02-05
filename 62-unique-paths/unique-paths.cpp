class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(2,vector<int>(n));
        for(int i=0;i<n;++i) dp[0][i]=1;
        for(int i=0;i<2;++i) dp[i][0]=1;
        for(int r=1;r<m;++r){
            for(int c=1;c<n;++c){
                dp[r%2][c]=dp[r%2][c-1]+dp[1-r%2][c];
            }
        }
        return dp[(m-1)%2][n-1];
    }
};