class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int tar) {
        unordered_map<int,int> ma;
        for(int i=0;i<nums.size();i++){
            int rem = tar-nums[i];
            if(ma.find(rem)!=ma.end()){
                return vector<int>({ma[rem],i});
            }
            ma.insert({nums[i],i});
        }
        return vector<int>({});
    }
};