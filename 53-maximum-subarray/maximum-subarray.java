class Solution {
    public int maxSubArray(int[] nums) {
        int sum= 0, ans= Integer.MIN_VALUE,n= nums.length;
        for(int i=0;i<n;i++){
            if(sum>=0) sum+= nums[i];
            else{
                sum= nums[i];
            }
            ans= Math.max(ans, sum);
        }
        return ans;
    }
}