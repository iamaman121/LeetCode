class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] ans= new int[n]; ans[0]= nums[0];
        for(int i=1;i<n;i++){
            ans[i]= ans[i-1]*nums[i];
        }
        int suffix= 1;
        for(int i=n-1;i>0;i--){
            ans[i]= ans[i-1]*suffix;
            suffix*= nums[i];
        }
        ans[0]= suffix;
        return ans;
    }
}