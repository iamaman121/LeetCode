class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int csum= 0;
        HashMap<Integer,Integer> cSumMapMod = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            csum= (csum+nums[i])%k;
            if(csum%k==0 && i>0) return true;
            else if(cSumMapMod.containsKey(csum)){
                if(cSumMapMod.get(csum)!=i-1) return true;
            }
            else cSumMapMod.put(csum,i);
        }
        return false;
    }
}