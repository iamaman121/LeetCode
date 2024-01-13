class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n= (int)nums.size(), ans=0;
        if(n<3) return 0;
        int pDiff=nums[1]-nums[0], count=0;
        for(int i=2;i<n;++i){
            if(nums[i]-nums[i-1]==pDiff){
                ans+=1+count;
                ++count;
            }
            else{
                pDiff=nums[i]-nums[i-1];
                count=0;
            }
        }
        return ans;
    }
};