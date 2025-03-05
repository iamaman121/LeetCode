class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int lft=1, rgt=1;
        for(int i=0;i<n;i++){
            ans[i]*= lft;
            lft*= nums[i];
        }
        for(int i=n-1;i>=0;i--){
            ans[i]*=rgt;
            rgt*=nums[i];
        }
        return ans;
    }
}