class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        unordered_map<int, int> ump;
        int maxFreq=0;
        for(int a: nums){
            ump[a]++;
            if(ump[a]>maxFreq) maxFreq= ump[a];
        }
        int cnt=0;
        for(auto v: ump){
            if(v.second== maxFreq) ++cnt;
        }
        return cnt*maxFreq;
    }
};