class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int tar) {
        unordered_map<int,int> umap;
        vector<int> ans;
        for(int i=0;i<(int)nums.size();++i){
            if(umap.find(tar-nums[i])==umap.end()){
                umap.insert({nums[i],i});
            } 
            else{
                ans ={umap[tar-nums[i]],i};
                break;
            }
        }
        return ans;
    }
};