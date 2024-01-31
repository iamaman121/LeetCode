class Solution {
public:
    int findMin(vector<int>& nums) {
        int lo=0, hi=(int)nums.size()-1, mid=-1, z=0;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(nums[mid]>=nums[lo] && nums[mid]<=nums[hi]){
                if(nums[z]>nums[mid]) z=mid;
                hi=mid-1;
            }
            else if(nums[mid]<=nums[lo] && nums[mid]<=nums[hi]){
                if(nums[z]>nums[mid]) z=mid;
                hi=mid-1;
            }
            else if(nums[mid]>=nums[lo] && nums[mid]>=nums[hi]){
                if(nums[z]>nums[mid]) z=mid;
                lo=mid+1;
            }
            else {
                
            }
        }
        return nums[z];
    }
};