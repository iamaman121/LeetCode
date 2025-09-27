class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int pre= 0, suff= 0, maxm= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre*= nums[i];
            suff*= nums[n-1-i];
            maxm= Math.max(maxm, Math.max(pre, suff));
        }
        return maxm;
    }
}