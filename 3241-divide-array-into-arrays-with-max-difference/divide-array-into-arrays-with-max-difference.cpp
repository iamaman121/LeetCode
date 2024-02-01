class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        int n=(int)nums.size();
        vector<vector<int>> newArrays;
        sort(nums.begin(),nums.end());
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]<=k){
                newArrays.push_back(vector<int>(nums.begin()+i,nums.begin()+i+3));
            }
            else {
                newArrays.clear();
                return newArrays;
            }
        }
        return newArrays;
    }
};