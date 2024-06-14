class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int totalIncrement= 0, currIncrement= 0;
        sort(nums.begin(),nums.end());
        for(int i=1;i<(int)nums.size();++i){
            if(nums[i]<=nums[i-1]){
                currIncrement= nums[i-1]-nums[i]+1;
                totalIncrement+= currIncrement;
                nums[i]= 1+nums[i-1];
            }
        }
        return totalIncrement;
    }
};