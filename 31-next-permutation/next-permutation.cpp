class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = (int)nums.size();
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                int idx=i+1;
                for(int j=i+2;j<n;j++){
                    if(nums[j]>nums[i] && nums[j]<nums[idx]){
                        idx=j;
                    }
                }
                swap(nums[idx],nums[i]);
                for(int j=idx+1;j<n;j++){
                    if(nums[j]>nums[j-1]){
                        swap(nums[j],nums[j-1]);
                    }
                }
                reverse(nums.begin()+i+1,nums.end());
                return;
            }
        }
        reverse(nums.begin(),nums.end());
    }
};