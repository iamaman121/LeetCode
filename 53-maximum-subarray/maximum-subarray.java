class Solution {
    public int maxSubArray(int[] nums) {
        int cmax= nums[0], maxm= nums[0];
        for(int i=1;i<nums.length;i++){
            cmax= Math.max(cmax+nums[i],nums[i]);
            maxm= Math.max(maxm, cmax);
        }
        return maxm;
    }
}