class Solution {
    public int maxSubArray(int[] nums) {
        int maximumSubArraySum= (int)-1e9, currSubArraySum= 0;
        for(int i=0;i<nums.length;++i){
            currSubArraySum=Math.max(currSubArraySum+nums[i], nums[i]);
            maximumSubArraySum= Math.max(maximumSubArraySum, currSubArraySum);
        }
        return maximumSubArraySum;
    }
}