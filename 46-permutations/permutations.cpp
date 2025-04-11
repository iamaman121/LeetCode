class Solution {
public:
    void permuteUtil(vector<int> arr, int idx, vector<vector<int>> &ans){
        if(idx==arr.size()){
            ans.push_back(arr);
            return;
        }
        for(int j=idx;j<arr.size();j++){
            vector<int> curr(arr);
            swap(curr[j],curr[idx]);
            permuteUtil(curr, idx+1, ans);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        permuteUtil(nums, 0, ans);
        return ans;
    }
};