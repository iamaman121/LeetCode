class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n= (int)nums.size();
        int i=0, j=2, count=0;
        while(j<n){
            if(j-i+1<3){
                ++j;
                continue;
            }
            if(nums[j]-nums[j-1]==nums[j-1]-nums[j-2]){
                count+= j-i-1;
                ++j;
            }
            else{
                i=j-1;
            }
            
        }
        return count;
    }
};