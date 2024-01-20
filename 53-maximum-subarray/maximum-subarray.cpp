class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int csum=0, maxm=INT_MIN;
        for(int v:nums){
            csum=max(v,csum+v);
            maxm=max(maxm,csum);
        }
        return maxm;
    }
};