class Solution {
public:
    void subsetXORSumUtil(vector<int> &nums, int idx, int &cxor, int &sum){
        if(idx== (int)nums.size()){
            sum+=cxor;
            return;
        }
        cxor^= nums[idx];
        subsetXORSumUtil(nums, idx+1, cxor, sum);
        cxor^= nums[idx];
        subsetXORSumUtil(nums, idx+1, cxor, sum);
    }
    int subsetXORSum(vector<int>& nums) {
        int cxor= 0, sum= 0;
        subsetXORSumUtil(nums, 0, cxor, sum);
        return sum;
    }
};