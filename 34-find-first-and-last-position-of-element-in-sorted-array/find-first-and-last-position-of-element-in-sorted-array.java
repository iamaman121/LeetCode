class Solution {
    private int findIndex(int[] nums, int target, boolean flag){
        int lo= 0, hi= nums.length-1, mid, n= nums.length;
        while(lo<=hi){
            mid= lo+ (hi-lo)/2;
            if(nums[mid]==target){
                if(flag){
                    if(mid==0 || nums[mid]!=nums[mid-1]) return mid;
                    else hi= mid-1;
                }
                else{
                    if(mid==n-1 || nums[mid]!=nums[mid+1]) return mid;
                    else lo= mid+1;
                }
            }
            else if(nums[mid]<target) lo= mid+1;
            else hi= mid-1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int fIdx= findIndex(nums, target, true), lIdx= findIndex(nums, target, false);
        return new int[]{fIdx, lIdx};
    }
}