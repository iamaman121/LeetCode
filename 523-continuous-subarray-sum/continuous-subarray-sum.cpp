class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> ump;
        int csum=0;
        for(int i=0;i<(int)nums.size();++i){
            csum+= nums[i];
            if(csum%k==0 && i>0) return true;
            if(csum>k) csum%= k;
            if(ump.find(csum)!=ump.end()){
                if(ump[csum]!=i-1)  return true;
            }
            else ump[csum]= i;
        }
        return false;
    }
};