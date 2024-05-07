class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n= (int)nums.size();
        vector<int> ans(n, 0);
        int pIdx=0, nIdx=1;
        for(int x: nums){
            if(x>0){
                ans[pIdx]=x;
                pIdx+=2;
            }
            else{
                ans[nIdx]=x;
                nIdx+=2;
            }
        }
        return ans;
    }
};