class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n= (int)nums.size();
        set<vector<int>> vis;
        unordered_set<int> ump;
        vector<int> temp;
        for(int i=0;i<=n-2;++i){
            for(int j=i+1;j<n;++j){
                if(ump.find(-nums[i]-nums[j])!=ump.end()){
                    temp={nums[i],nums[j],-nums[i]-nums[j]};
                    sort(temp.begin(),temp.end());
                    vis.insert(temp);
                }
            }
            if(ump.find(nums[i])==ump.end()) ump.insert(nums[i]);
        }
        return vector<vector<int>> ({vis.begin(),vis.end()});
    }
};