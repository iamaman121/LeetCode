class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans= 0, lgei= 0, prevValidCount= 0, n= nums.length;
        for(int ep=0;ep<n;ep++){
            if(nums[ep]>right){
                lgei= ep+1;
                prevValidCount= 0;
            }
            else if(nums[ep]>=left && nums[ep]<=right){
                ans+= (ep-lgei+1);
                prevValidCount= ep-lgei+1;
            }
            else{
                ans+= prevValidCount;
            }
        }
        return ans;
    }
}