class Solution {
    public int rob(int[] nums) {
        int n= nums.length, ans=0;
        if(n==1) return nums[0];
        int one= nums[0], two= Math.max(nums[0],nums[1]), three= 0;
        for(int i=2;i<=n-2;i++){
            three= one+nums[i];
            if(three<two) three= two;
            one= two; two= three;
        }   
        ans= two;
        one=0; two= nums[1];
        for(int i=2;i<n;i++){
            three= one+nums[i];
            if(three<two) three= two;
            one= two; two= three;
        }
        return Math.max(ans, three);
    }
}