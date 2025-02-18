class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> cache;
        for(int x:nums){
            if(cache.count(x)) return true;
            else cache.insert(x);
        }
        return false;
    }
};