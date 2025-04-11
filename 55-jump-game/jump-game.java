class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length, curr=0, last=0;
        while(last<=n-2 && curr<=last){
            last= Math.max(last,curr+nums[curr++]);
        }
        return last>=n-1;
    }
}