class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> ust;
        for(int i=0; i<(int)nums.size(); ++i){
            ust.insert(nums[i]);
        }
        int maxLen=0, currLen;
        for(int a: ust){
            if(ust.find(a-1)!=ust.end()) continue;
            currLen=1;
            while(ust.find(a+1)!=ust.end()){
                ++currLen;
                ++a;
            }
            maxLen=max(maxLen, currLen);
        }
        return maxLen;
    }
};