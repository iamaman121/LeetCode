class Solution {
public:
    int combinationSum4(vector<int>& nums, int tar) {
        vector<unsigned int> dp(tar+1);
        dp[0]=1;
        for(int i=0; i<tar; ++i){
            if(dp[i]==0) continue;
            for(int num: nums){
                if(i+num<=tar) dp[i+num]+=dp[i];
            }
        }
        return dp[tar];
    }
};