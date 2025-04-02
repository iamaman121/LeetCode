class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        if(n==1 || nums[0]!=nums[1]) return nums[0];
        else if(nums[n-2]!=nums[n-1]) return nums[n-1];
        else{
            int lo=1, hi= n-2, mid;
            while(lo<=hi){
                mid= lo+(hi-lo)/2;
                if(mid%2==1){
                    mid--;
                }

                if(nums[mid]==nums[mid+1]){
                    lo= mid+2;
                }
                else{
                    if(nums[mid]!=nums[mid-1]) return nums[mid];
                    else hi= mid-2;
                }
            }
        }
        return -1;
    }
}