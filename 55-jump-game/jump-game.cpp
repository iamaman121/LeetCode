class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n= (int)nums.size(), i=0, maxm=0;
        for(i=0;i<min(maxm+1,n); ++i){
            maxm=max(maxm,i+nums[i]);
        }
        return i==n;
    }
};