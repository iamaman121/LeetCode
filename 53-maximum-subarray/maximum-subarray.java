class Solution {
    private int maxSubArrayUtil(int[] nums, int i, int j){
        if(i>j) return (int)-1e5;
        int m= (i+j)/2;
        int ansL= maxSubArrayUtil(nums, i, m-1);
        int ansR= maxSubArrayUtil(nums, m+1, j);
        int ansM= nums[m];
        int k= m+1, curr= ansM;
        while(k<=j){
            curr+= nums[k++];
            if(curr>ansM) ansM= curr;
        }
        k= m-1; curr= ansM;
        while(k>=i){
            curr+= nums[k--];
            if(curr>ansM) ansM= curr;
        }
        return Math.max(Math.max(ansL,ansR),ansM);
    }
    public int maxSubArray(int[] nums) {
        return maxSubArrayUtil(nums, 0, nums.length-1);
    }
}