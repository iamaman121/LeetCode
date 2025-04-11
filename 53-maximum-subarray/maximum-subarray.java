class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length, cmax= 0, maxm= nums[0];
        for(int i=0;i<nums.length;i++){
            cmax+= nums[i];
            if(nums[i]>cmax) cmax= nums[i];
            if(maxm<cmax) maxm= cmax;
        }
        return maxm;
    }
}