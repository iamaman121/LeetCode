class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1 || nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int lo = 1, hi = n-2, mid;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]<nums[mid-1]){
                hi = mid-1;
            }
            else{
                lo = mid+1;                
            }
        }
        return -1;
    }
}