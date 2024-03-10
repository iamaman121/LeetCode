class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> val(1001);
        for(int x: nums1) val[x]|=1;
        for(int x: nums2) val[x]|=2;
        vector<int> ans;
        for(int i=0;i<=1000;++i){
            if(val[i]==3) ans.push_back(i);
        }
        return ans;
    }
};