class Solution {
   public int[] productExceptSelf(int[] nums) {
        int prod = 1, countZero= 0, n= nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0) prod*= nums[i];
            else countZero++;
        }
        int[] ans = new int[n];
        if(countZero==0){
            for(int i=0;i<n;i++){
                ans[i]= prod/nums[i];
            }
        } 
        else if(countZero==1){
            for(int i=0;i<n;i++){
                if(nums[i]==0) ans[i]= prod;
            }
        }
        return ans;
    }
}