class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n= (int)nums.size();
        int idx= -1;
        for(int i=n-2;i>=0;--i){
            if(nums[i]<nums[i+1]){
                idx= i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums.begin(),nums.end());
            return;
        }
        int swapIdx= idx+1;
        for(int i=idx+2;i<n;++i){
            if(nums[i]>nums[idx] && nums[i]<nums[swapIdx]){
                swapIdx= i;
            }
        }
        swap(nums[idx], nums[swapIdx]);
        sort(nums.begin()+idx+1,nums.end());
    }
};