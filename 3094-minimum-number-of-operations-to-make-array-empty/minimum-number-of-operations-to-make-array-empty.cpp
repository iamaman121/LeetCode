class Solution {
public:
    int minOperations(vector<int>& nums) {
        unordered_map<int,int> ump;
        int res=0;
        for(int a: nums){
            ump[a]++;
        }
        for(pair<int,int> p : ump){
            if(p.second == 1) return -1;
            res+=p.second/3;
            p.second%=3;
            res+=(p.second>0);
        }
        return res;
    }
};