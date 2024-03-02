class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n=(int) nums.size();
        for(int i=0;i<n;++i){
            nums[i]*=nums[i];
        }
        vector<int>res(n);
        int idx=n-1;
        int l=0,r=n-1;
        while(l<=r){
            if(nums[l]>=nums[r]){
                res[idx--]=nums[l++];    
            }
            else{
                res[idx--]=nums[r--];  
            }
        }
        return res;
    }
};