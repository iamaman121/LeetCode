class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modSum= new int[k];
        modSum[0]= 1;
        int csum= 0, ans= 0;
        for(int i=0;i<nums.length;++i){
            csum= (csum+nums[i]%k+k)%k;
            ans+= modSum[csum];
            modSum[csum]++;
        }
        return ans;
    }
}