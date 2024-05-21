class Solution {
public:
    void generateAllSubSets(vector<int>& nums, int idx, vector<vector<int>> &allSubSets,
            vector<int> &subSet ){
        if(idx== (int)nums.size()){
            allSubSets.push_back(subSet);
            return;
        }
        subSet.push_back(nums[idx]);
        generateAllSubSets(nums, idx+1, allSubSets, subSet);
        subSet.pop_back();
        generateAllSubSets(nums, idx+1, allSubSets, subSet);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> allSubSets;
        vector<int> subSet;
        generateAllSubSets(nums, 0, allSubSets, subSet);
        return allSubSets;
    }
};