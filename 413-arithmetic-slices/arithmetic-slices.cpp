class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n= (int)nums.size(), ans=0;
        if(n<3) return 0;
        int count=0;
        for(int i=2;i<n;++i){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                ans+=1+count;
                ++count;
            }
            else{
                count=0;
            }
        }
        return ans;
    }
};