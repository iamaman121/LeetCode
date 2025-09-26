class Solution {
    public int[] runningSum(int[] nums) {
        int n= nums.length, csum=0;
        int[] pf= new int[n];
        for(int i=0;i<n;i++){
            csum+= nums[i];
            pf[i]= csum;
        }
        return pf;
    }
}