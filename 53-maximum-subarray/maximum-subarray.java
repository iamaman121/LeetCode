class Solution {
    public int maxSubArray(int[] nums) {
        int csum= (int)-1e5, msum= csum;
        for(int num: nums){
            csum= Math.max(csum+num, num);
            msum= Math.max(csum,msum);
        }
        return msum;
    }
}