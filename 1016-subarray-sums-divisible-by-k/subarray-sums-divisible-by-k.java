class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSumModMap = new HashMap<>();
        prefixSumModMap.put(0,1);
        int csum=0, ans=0;
        for(int i=0;i<nums.length;++i){
            csum+= nums[i];
            while(csum<0) csum+=k;
            csum= csum%k;
            if(prefixSumModMap.containsKey(csum)) ans+= prefixSumModMap.get(csum);
            prefixSumModMap.put(csum,
                prefixSumModMap.containsKey(csum)?prefixSumModMap.get(csum)+1:1);
        }
        return ans;
    }
}