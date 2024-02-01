class Solution {
public:
    int search(vector<int>& nums, int tar) {
        int lo=0, hi=(int)nums.size()-1, z=-1;
        while(lo<hi){
            int mid=(lo+hi)>>1;
            if(nums[lo]<nums[hi]){
                if(nums[lo]>tar || nums[hi]<tar) return -1;
                else if(nums[mid]<tar){
                    lo=mid+1;
                }
                else hi=mid;
            }
            else if(nums[mid]>=nums[lo]){
                if(nums[mid]<tar || nums[lo]>tar){
                    lo=mid+1;
                }
                else{
                    hi=mid;
                }
            }
            else{
                if(nums[mid]<tar && tar<=nums[hi]){
                    lo=mid+1;
                }
                else hi=mid;
            }
        }
        return nums[lo]==tar?lo:-1;
    }
};