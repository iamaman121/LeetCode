class Solution {
public:
    int specialArray(vector<int>& nums) {
        sort(nums.rbegin(), nums.rend());
        int n= (int)nums.size();
        for(int i=0;i<n;++i){
            if(i<n-1 && nums[i]==nums[i+1]) continue;
            int x= i+1;
            if(nums[i]<x) continue;
            if(i<n-1 && nums[i+1]>=x)   continue;
            return x;
        }
        return -1;
    }
};