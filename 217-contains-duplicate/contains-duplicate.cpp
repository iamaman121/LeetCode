class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> haveSeen;
        for(int x: nums){
            if(haveSeen.count(x)) return true;
            haveSeen.insert(x);
        }
        return false;
    }
};