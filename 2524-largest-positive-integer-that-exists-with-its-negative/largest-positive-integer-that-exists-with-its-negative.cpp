class Solution {
public:
    int findMaxK(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int beg= 0, end= (int)nums.size()-1;
        while(beg<end){
            if(nums[beg]==-nums[end]){
                return nums[end];
            }
            else if(nums[beg]+nums[end]>0){
                --end;
            }
            else ++beg;
        }
        return -1;
    }
};