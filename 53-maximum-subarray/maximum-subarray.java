class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length, currMax= 0, globalMax= Integer.MIN_VALUE;
        for(int val : nums){
            currMax= Math.max(currMax+val, val);
            globalMax= Math.max(globalMax, currMax);
        } 
        return globalMax;
    }
}